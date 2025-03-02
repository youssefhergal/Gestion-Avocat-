package org.example.gestionavocatv2.config;

import java.util.Locale;

import org.example.gestionavocatv2.validation.EmailValidator;
import org.example.gestionavocatv2.validation.PasswordMatchesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
@ComponentScan(basePackages = { "org.example.gestionavocatv2.controller" })
@EnableWebMvc
@PropertySource( value = "classpath:messages_fr_FR.properties" , encoding = "UTF-8")
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private MessageSource messageSource;

    public MvcConfig() {
        super();
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/Avocat").setViewName("Admin/Avocat/");
        registry.addViewController("/Client").setViewName("Client/");
        registry.addViewController("/contacts").setViewName("Admin/contacts");
        registry.addViewController("/mailbox").setViewName("Admin/mailbox");
        registry.addViewController("/mail_detail").setViewName("Admin/mail_detail");
        registry.addViewController("/layouts").setViewName("Admin/laayouts");
        registry.addViewController("/metrics").setViewName("Admin/metrics");
        registry.addViewController("/widgets").setViewName("Admin/widgets");
        registry.addViewController("/form_basic").setViewName("Admin/form_basic");
        registry.addViewController("/form_advanced").setViewName("Admin/form_advanced");
        registry.addViewController("/form_wizard").setViewName("Admin/form_wizard");
        registry.addViewController("/form_file_upload").setViewName("Admin/form_file_upload");
        registry.addViewController("/form_editors").setViewName("Admin/form_editors");
        registry.addViewController("/form_autocomplete").setViewName("Admin/form_autocomplete");
        registry.addViewController("/form_markdown").setViewName("Admin/form_markdown");
        registry.addViewController("/contacts").setViewName("Admin/contacts");
        registry.addViewController("/profile_2").setViewName("Admin/profile_2");
        registry.addViewController("/contacts_2").setViewName("Admin/contacts_2");
        registry.addViewController("/projects").setViewName("Admin/projects");
        registry.addViewController("/project_detail").setViewName("Admin/project_detail");
        registry.addViewController("/activity_stream").setViewName("Admin/activity_stream");
        registry.addViewController("/teams_board").setViewName("Admin/teams_board");
        registry.addViewController("/full_height").setViewName("Admin/full_height");
        registry.addViewController("/vote_list").setViewName("Admin/vote_list");
        registry.addViewController("/file_manager").setViewName("Admin/file_manager");
        registry.addViewController("/calendar").setViewName("Admin/calendar");
        registry.addViewController("/issue_tracker").setViewName("Admin/issue_tracker");
        registry.addViewController("/blog").setViewName("Admin/blog");
        registry.addViewController("/article").setViewName("Admin/article");
        registry.addViewController("/faq").setViewName("Admin/faq");
        registry.addViewController("/timeline").setViewName("Admin/timeline");
        registry.addViewController("/pin_board").setViewName("Admin/pin_board");
        registry.addViewController("/search_results").setViewName("Admin/search_results");
        registry.addViewController("/lockscreen").setViewName("Admin/lockscreen");
        registry.addViewController("/invoice").setViewName("Admin/invoice");
        registry.addViewController("/login").setViewName("Admin/login");
        registry.addViewController("/login_two_columns").setViewName("Admin/login_two_columns");
        registry.addViewController("/forgot_password").setViewName("Admin/forgot_password");
        registry.addViewController("/register").setViewName("Admin/register");
        registry.addViewController("/404").setViewName("Admin/404");
        registry.addViewController("/500").setViewName("Admin/500");
        registry.addViewController("/empty_page").setViewName("Admin/empty_page");
        registry.addViewController("/toastr_notifications").setViewName("Admin/toastr_notifications");
        registry.addViewController("/nestable_list").setViewName("Admin/nestable_list");
        registry.addViewController("/agile_board").setViewName("Admin/agile_board");
        registry.addViewController("/timeline_2").setViewName("Admin/timeline_2");
        registry.addViewController("/diff").setViewName("Admin/diff");
        registry.addViewController("/pdf_viewer").setViewName("Admin/pdf_viewer");
        registry.addViewController("/i18support").setViewName("Admin/i18support");
        registry.addViewController("/sweetalert").setViewName("Admin/sweetalert");
        registry.addViewController("/idle_timer").setViewName("Admin/idle_timer");
        registry.addViewController("/truncate").setViewName("Admin/truncate");
        registry.addViewController("/password_meter").setViewName("Admin/password_meter");
        registry.addViewController("/spinners").setViewName("Admin/spinners");
        registry.addViewController("/spinners_usage").setViewName("Admin/spinners_usage");
        registry.addViewController("/tinycon").setViewName("Admin/tinycon");
        registry.addViewController("/google_maps").setViewName("Admin/google_maps");
        registry.addViewController("/datamaps").setViewName("Admin/datamaps");
        registry.addViewController("/social_buttons").setViewName("Admin/social_buttons");
        registry.addViewController("/code_editor").setViewName("Admin/code_editor");
        registry.addViewController("/modal_window").setViewName("Admin/modal_window");
        registry.addViewController("/clipboard").setViewName("Admin/clipboard");
        registry.addViewController("/text_spinners").setViewName("Admin/text_spinners");
        registry.addViewController("/forum_main").setViewName("Admin/forum_main");
        registry.addViewController("/validation").setViewName("Admin/validation");
        registry.addViewController("/tree_view").setViewName("Admin/tree_view");
        registry.addViewController("/loading_buttons").setViewName("Admin/loading_buttons");
        registry.addViewController("/chat_view").setViewName("Admin/chat_view");
        registry.addViewController("/masonry").setViewName("Admin/masonry");
        registry.addViewController("/tour").setViewName("Admin/tour");
        registry.addViewController("/typography").setViewName("Admin/typography");
        registry.addViewController("/icons").setViewName("Admin/icons");
        registry.addViewController("/draggable_panels").setViewName("Admin/draggable_panels");
        registry.addViewController("/buttons").setViewName("Admin/buttons");
        registry.addViewController("/video").setViewName("Admin/video");
        registry.addViewController("/tabs_panels").setViewName("Admin/tabs_panels");
        registry.addViewController("/tabs").setViewName("Admin/tabs");
        registry.addViewController("/notifications").setViewName("Admin/notifications");
        registry.addViewController("/helper_classes").setViewName("Admin/helper_classes");
        registry.addViewController("/badges_labels").setViewName("Admin/badges_labels");
        registry.addViewController("/table_basic").setViewName("Admin/table_basic");
        registry.addViewController("/table_data_tables").setViewName("Admin/table_data_tables");
        registry.addViewController("/table_foo_table").setViewName("Admin/table_foo_table");
        registry.addViewController("/jq_grid").setViewName("Admin/jq_grid");
        registry.addViewController("/ecommerce_products_grid").setViewName("Admin/ecommerce_products_grid");
        registry.addViewController("/ecommerce_product_list").setViewName("Admin/ecommerce_product_list");
        registry.addViewController("/ecommerce_product").setViewName("Admin/ecommerce_product");
        registry.addViewController("/ecommerce_product_detail").setViewName("Admin/ecommerce_product_detail");
        registry.addViewController("/ecommerce-cart").setViewName("Admin/ecommerce-cart");
        registry.addViewController("/ecommerce-orders").setViewName("Admin/ecommerce-orders");
        registry.addViewController("/ecommerce_payments").setViewName("Admin/ecommerce_payments");
        registry.addViewController("/basic_gallery").setViewName("Admin/basic_gallery");
        registry.addViewController("/slick_carousel").setViewName("Admin/slick_carousel");
        registry.addViewController("/carousel").setViewName("Admin/carousel");
        registry.addViewController("/landing").setViewName("Admin/landing");
        registry.addViewController("/package").setViewName("Admin/package");
        registry.addViewController("/grid_options").setViewName("Admin/grid_options");
        registry.addViewController("/mail_compose").setViewName("Admin/mail_compose");
        registry.addViewController("/email_template").setViewName("Admin/email_template");
        registry.addViewController("/dashboard_2").setViewName("Admin/dashboard_2");
        registry.addViewController("/dashboard_3").setViewName("Admin/dashboard_3");
        registry.addViewController("/dashboard_5").setViewName("Admin/dashboard_5");
        registry.addViewController("/dashboard_4_1").setViewName("Admin/dashboard_4_1");

        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/login");
        registry.addViewController("/index.html");
        registry.addViewController("/loginRememberMe");
        registry.addViewController("/customLogin");
        registry.addViewController("/registration.html");
        registry.addViewController("/registrationCaptcha.html");
        registry.addViewController("/logout.html");
        registry.addViewController("/homepage.html");
        registry.addViewController("/notfound.html");
        registry.addViewController("/dashboard.html");
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**", "/Admin/**", "/Client/**", "/css/**", "/js/**", "/assets/**")
                .addResourceLocations("classpath:/static/Admin/", "classpath:/static/Client/", "classpath:/static/css/", "classpath:/static/js/", "classpath:/static/assets/");
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public EmailValidator usernameValidator() {
        return new EmailValidator();
    }

    @Bean
    public PasswordMatchesValidator passwordMatchesValidator() {
        return new PasswordMatchesValidator();
    }

    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    // Optional: you can set up a global validator if needed
    // @Override
    // public Validator getValidator() {
    //     LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    //     validator.setValidationMessageSource(messageSource);
    //     return validator;
    // }
}
