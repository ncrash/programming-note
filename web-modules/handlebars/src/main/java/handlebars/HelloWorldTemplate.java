package handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import java.io.IOException;

public class HelloWorldTemplate {
	public static void main(String[] args) throws IOException {
		Handlebars handlebars = new Handlebars();

		Template template = handlebars.compile("mytemplate");

		System.out.println(template.apply("Handlebars.java"));
	}
}
