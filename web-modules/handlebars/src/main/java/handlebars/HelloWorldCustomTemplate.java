package handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.AbstractTemplateLoader;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;

import java.io.IOException;

public class HelloWorldCustomTemplate {
	public static void main(String[] args) throws IOException {
		AbstractTemplateLoader loader = new ClassPathTemplateLoader();
		loader.setPrefix("/templates");
		loader.setSuffix(".html");
		Handlebars handlebars = new Handlebars(loader);

		Template template = handlebars.compile("mytemplate");

		System.out.println(template.apply("Handlebars.java"));
	}
}
