package handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import java.io.IOException;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		Handlebars handlebars = new Handlebars();

		Template template = handlebars.compileInline("Hello {{this}}!");

		System.out.println(template.apply("Handlebars.java"));
	}
}
