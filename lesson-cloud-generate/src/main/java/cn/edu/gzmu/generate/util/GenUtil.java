package cn.edu.gzmu.generate.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成工具类
 *
 * @author echo
 * @version 1.0
 * @date 19-4-9 21:05
 */
@Slf4j
public class GenUtil {
    private static final String UNDERLINE = "_";
    private static final Map<String, String> MYSQL_TO_JAVA = new HashMap<>();
    public static final String SUFFIX = ".java";

    static {
        MYSQL_TO_JAVA.put("VARCHAR", "java.lang.String");
        MYSQL_TO_JAVA.put("BIGINT", "java.lang.Long");
        MYSQL_TO_JAVA.put("DATE", "java.time.LocalDate");
        MYSQL_TO_JAVA.put("FLOAT", "java.lang.Float");
        MYSQL_TO_JAVA.put("TINYINT", "java.lang.Integer");
        MYSQL_TO_JAVA.put("INT", "java.lang.Integer");
        MYSQL_TO_JAVA.put("BINARY", "java.lang.byte");
        MYSQL_TO_JAVA.put("SMALLINT", "java.lang.Short");
        MYSQL_TO_JAVA.put("BIT", "java.lang.Boolean");
    }

    /**
     * 获取项目路径
     *
     * @return 路径
     */
    public static String getParentPath() {
        return System.getProperty("user.dir") + File.separatorChar;
    }

    /**
     * 文件夹路径拼接
     *
     * @param dirNames 文件夹名称
     * @return 结果
     */
    public static String dirPathContact(String... dirNames) {
        StringBuilder result = new StringBuilder();
        for (String dirName : dirNames) {
            result.append(dirName).append(File.separatorChar);
        }
        return result.toString();
    }

    /**
     * 下划线命名转驼峰式命名
     *
     * @param para 下划线命名
     * @return 驼峰式命名
     */
    public static String underlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        for (String s : para.split(UNDERLINE)) {
            if (!para.contains("_")) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 下划线命名转驼峰式命名
     *
     * @param para            下划线命名
     * @param firstCharChange 首字母是否转换
     * @return 驼峰式命名
     */
    public static String underlineToHump(String para, boolean firstCharChange) {
        String result = underlineToHump(para);
        return firstCharChange ? result.substring(0, 1).toUpperCase() + result.substring(1) : result;
    }

    /**
     * 数据库字段转换
     *
     * @param mysqlDataType 数据库字段类型
     * @return 转换结果
     */
    public static String fieldConversion(String mysqlDataType) {
        return MYSQL_TO_JAVA.getOrDefault(mysqlDataType, "Object");
    }

    /**
     * 创建目录
     *
     * @param path 目录
     */
    public static void createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            log.info("Dir not exists.Now start create...The create result is {}", dir.mkdirs());
        }
    }

    /**
     * 代码生成目录
     *
     * @param moduleName 模块名
     * @param packageName 包名
     * @return 目录
     */
    public static String generateDir(String moduleName, String packageName) {
        return GenUtil.dirPathContact(GenUtil.getParentPath() + moduleName, "src", "main", "java",
                packageName.replaceAll("\\.", File.separator));
    }
}
