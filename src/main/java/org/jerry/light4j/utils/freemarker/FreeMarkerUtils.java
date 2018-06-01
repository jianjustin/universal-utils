package org.jerry.light4j.utils.freemarker;

import java.io.File;
import java.io.IOException;

import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * freeMarker模板工具�?
 * @author Administrator
 *
 */
public class FreeMarkerUtils {
	
	private FreeMarkerUtils(){}
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static{
    	//这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }
    
    /**
     * 根据模板名称和模板路径获取模板实�?
     * @param templateName
     * @param templatePath
     * @return
     */
    public static Template getTemplate(String templateName,String templatePath){
    	Template template = null;
            try {
            	CONFIGURATION.setDirectoryForTemplateLoading(new File(templatePath));
            	template = CONFIGURATION.getTemplate(templateName);
			} catch (IOException e) {
				return template;
			}
            return template;
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

}
