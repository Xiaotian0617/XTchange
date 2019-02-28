1tokenApi使用说明
--------------
### 1.使用技术：okhttp3 + retrofit2
### 2.依赖maven，内部使用 (用户可上传nexus使用)
```
        <dependency>
               <groupId>com.ailu.1tokex</groupId>
               <artifactId>1token-api</artifactId>
               <version>1.0.0-SNAPSHOT</version>
        </dependency>
```
### 3.简单使用方式:
```
 public static void main(String[] args) {
         String appKey = "";
         String secert = "";
         OneTokenClient oneTokenClient = new OneTokenClient(config(appKey,secert,null,true,"127.0.0.1","1087"));
         String orders = oneTokenClient.client.executeSync(oneTokenClient.api.getOrders("okef","liujianshu","end"));
         String result = oneTokenClient.client.executeSync(oneTokenClient.api.getInfo("okef","liujianshu"));
         System.out.println(result);
  }
  
   private static APIConfiguration config(String apiKey, String secretKey, String passphrase, boolean proxyEnable, String url, String port) {
          final APIConfiguration config = new APIConfiguration();
          config.setEndpoint(OneToken.baseUrl);
          // apiKey，api注册成功后页面上有
          config.setApiKey(apiKey);
          // secretKey，api注册成功后页面上有
          config.setSecretKey(secretKey);
          config.setPassphrase(passphrase);
          config.setPrint(true);
          if (proxyEnable) {
              config.setEnableProxy(true);
              config.setProxyUrl(url);
              config.setProxyPort(Integer.valueOf(port));
          }
          return config;
      }
     
```
### 4.Spring 或 Spring Boot使用方式:
```
@RestController
public class TestOneTokenApi {

    @Autowired
    private GeneralAPIService generalAPIService;

    @GetMapping("/getAccount")
    public ServerTime getAccount() {
         AccountService accountService = new AccountServiceImpl(new OneTokenClient(config()));
         Account account = accountService.getAccount("okef", "liujianshu");
         log.info(JSON.toJSONString(account));
    }
    
    @Bean
    public APIConfiguration okexApiConfig() {
        final APIConfiguration config = new APIConfiguration();
                  config.setEndpoint(OneToken.baseUrl);
                  // apiKey，api注册成功后页面上有
                  config.setApiKey(apiKey);
                  // secretKey，api注册成功后页面上有
                  config.setSecretKey(secretKey);
                  config.setPassphrase(passphrase);
                  config.setPrint(true);
                  if (proxyEnable) {
                      config.setEnableProxy(true);
                      config.setProxyUrl(url);
                      config.setProxyPort(Integer.valueOf(port));
                  }
                  return config;
    }
}
```

