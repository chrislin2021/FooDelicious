package foodelicious;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@SpringBootApplication
public class FooDeliciousApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooDeliciousApplication.class, args);
	}

	@Bean
	public TilesConfigurer tilesConfig() {
		TilesConfigurer tilesConfig = new TilesConfigurer();
		String[] defs = { "WEB-INF/tiles.xml" };
		tilesConfig.setDefinitions(defs);
		return tilesConfig;
	}

	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setUploadTempDir(new FileSystemResource("Image/"));
		resolver.setMaxUploadSize(600000000);
		return resolver;
	}
}
