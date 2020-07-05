package com.test.cache.guava;

import com.google.common.cache.*;
import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
public class GuavaCache {
    private static Gson gson = new Gson();
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            //缓存大小
            .maximumSize(20)
            //缓存失效时间
            .expireAfterAccess(20, TimeUnit.SECONDS)
            .removalListener(new RemovalListener<String, String>() {
                @Override
                public void onRemoval(RemovalNotification<String, String> removalNotification) {
                    log.info("remove cache info:{}", gson.toJson(removalNotification));
                }
            }).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    log.info("loading cache : key:{}", s);
                    return s + "_" + s;
                }
            });

    private static String getFromCache(String key) {
        try {
            String result = cache.get(key);
            return result;
        } catch (ExecutionException e) {
            log.error("error", e);
        }
        return null;
    }

    //删除某个key
    public static void remove(String key) {
        cache.invalidate(key);
    }
    //清空全部缓存
    public static void removeAll(){
        cache.invalidateAll();
    }

    /**
     * 如果缓存中有该缓存则会触发缓存监听器
     * @param key
     * @param value
     */
    public static void putCache(String key,String value){
        cache.put(key,value);
        log.info("put success 保存成功！");
    }

    /**
     * 获取缓存中所有的数据的map
     * @return
     */
    public static ConcurrentMap<String,String> viewCache(){
        return cache.asMap();
    }
    public static void main(String[] args) {

    }
}
