package foodelicious;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import foodelicious.websocket.init.InitialListener;

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

	// 啟動一個實作ServletContextListener介面的Bean, Tomcat會在啟動
	// 本應用系統時，自動執行它的contextInitialized()方法。
	@Bean
	public InitialListener initialListener() {
		return new InitialListener();
	}

}
