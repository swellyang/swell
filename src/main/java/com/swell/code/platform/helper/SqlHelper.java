package com.swell.code.platform.helper;

import com.alibaba.fastjson.JSONObject;
import com.swell.code.platform.utils.XmlBean;
import com.swell.code.platform.utils.XmlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fei.yang
 * @time 创建时间：2018年9月12日 下午6:36:53
 */

public class SqlHelper {

    private static final Log log = LogFactory.getLog(SqlHelper.class);

    private static Map<String, String> sqlResourcesMap = null;

    private static Configuration cfg = null;

    // 获取sql
    public static String getSql(String sqlId, Map<String, Object> sqlParams) {
        String sqlText = "";
        try {
            if (cfg == null) {
                initSqls();
            }

            Template template = cfg.getTemplate(sqlId, "utf-8");
            StringWriter writer = new StringWriter();
            template.process(sqlParams, writer);
            sqlText = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return sqlText;
    }

    // 获取sql
    public static String getSql(String sqlId) {
        return getSql(sqlId, new HashMap<>());
    }

    public static String getSqlFromJson(String sqlId, JSONObject json) {
        String sqlText = "";
        try {
            if (cfg == null) {
                initSqls();
            }

            Template template = cfg.getTemplate(sqlId, "utf-8");
            StringWriter writer = new StringWriter();
            template.process(json, writer);
            sqlText = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return sqlText;
    }

    // 初始化sql
    public static void initSqls() {
        try {
            log.warn("开始加载SQL资源......");
            cfg = new Configuration(Configuration.VERSION_2_3_25);
            StringTemplateLoader strTemplateLoader = new StringTemplateLoader();

            sqlResourcesMap = new HashMap<>();
            String classpath = ResourceUtils.getURL("classpath:").getPath();
            File statements = new File(classpath + "statements");
            File[] files = statements.listFiles();
            for (File file : files) {
                XmlBean root = XmlUtil.parseBean(file.getAbsolutePath());
                List<XmlBean> list = root.getChildren();
                for (XmlBean bean : list) {
                    if (sqlResourcesMap.containsKey(bean.getId())) {
                        log.warn("SQL资源加载重复[" + bean.getId() + "]");
                    } else {
                        sqlResourcesMap.put(bean.getId(), bean.getTextData());
                        strTemplateLoader.putTemplate(bean.getId(), bean.getTextData());
                    }
                }
            }
            cfg.setTemplateLoader(strTemplateLoader);
            cfg.setDefaultEncoding("UTF-8");
            log.warn("加载SQL资源完成......");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
