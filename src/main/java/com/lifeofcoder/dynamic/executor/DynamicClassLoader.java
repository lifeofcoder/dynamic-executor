package com.lifeofcoder.dynamic.executor;

import java.net.URLClassLoader;
import java.net.URL;

/**
 * 自定义类加载器，用于动态加载类 
 * </BR>继承自 @see URLClassLoader
 *
 * @author xbc
 * @date 2019年1月9日 
 *
 */
public class DynamicClassLoader extends URLClassLoader {
    public DynamicClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    public Class<?> findClassByClassName(String className) throws ClassNotFoundException {
        return this.findClass(className);
    }

    public Class<?> loadClassByBytes(byte[] classData) {
        return this.defineClass(null, classData, 0, classData.length);
    }
}