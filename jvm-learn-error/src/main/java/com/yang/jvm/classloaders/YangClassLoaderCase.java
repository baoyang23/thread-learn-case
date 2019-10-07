package com.yang.jvm.classloaders;

import java.io.InputStream;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-7
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class YangClassLoaderCase {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte [] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (Exception e){

                    throw new ClassNotFoundException(name);
                }


                //return super.loadClass(name);

            }
        };

        Object obj = myLoader.loadClass("com.yang.jvm.classloaders.YangClassLoaderCase").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.yang.jvm.classloaders.YangClassLoaderCase);
    }


}
