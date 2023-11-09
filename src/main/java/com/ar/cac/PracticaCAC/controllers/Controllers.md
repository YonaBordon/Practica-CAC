En Spring, la carpeta controllers se utiliza para almacenar las clases que manejan las solicitudes HTTP entrantes y las envían a los servicios correspondientes para su procesamiento. Estas clases se conocen como controladores y se anotan con @Controller o @RestController. Los controladores también pueden tener métodos anotados con @RequestMapping para mapear solicitudes HTTP específicas a métodos de controlador específicos.

```
@RestController
@RequestMapping("/api")
public class UserController {

  private UserService userService;
   
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.status(200).body(userService.getAllUsers());
  }

}
````


# ¿Para qué sirve el @Autowired en Spring?

La anotación `@Autowired` en Spring se utiliza para la inyección de dependencias automática. Esta anotación se usa para conectar componentes de Spring de manera automática y eliminar la necesidad de crear manualmente instancias de las clases requeridas. Puedes usar `@Autowired` en campos, constructores o métodos en tus componentes de Spring para indicar a Spring que debe proporcionar las dependencias necesarias en tiempo de ejecución. A continuación, se explican los diferentes usos de `@Autowired`:

1. **Inyección de dependencias en campos**:

   ```java
   @Autowired
   private MiServicio servicio;
   ```
   En este ejemplo, Spring automáticamente inyectará una instancia de MiServicio en el campo servicio cuando se crea una instancia de la clase que contiene este campo.

2. **Inyección de dependencias en constructores**:

   ```
   private MiServicio servicio;
  
   @Autowired
   public MiControlador(MiServicio servicio) {
       this.servicio = servicio;
   }
   ```
   En este caso, el constructor del controlador recibe una instancia de MiServicio automáticamente cuando se crea una instancia del controlador.

3. **Inyección de dependencias en métodos:**:

   ```
   private MiServicio servicio;

   @Autowired
   public MiControlador(MiServicio servicio) {
       this.servicio = servicio;
   }
   ```
   Puedes usar @Autowired en métodos de configuración (como el método setServicio en el ejemplo) para inyectar dependencias. Spring automáticamente invocará este método y proporcionará la instancia de MiServicio cuando se cree el bean.

  La anotación @Autowired funciona en conjunto con el mecanismo de contenedor de Spring. Cuando se encuentra una anotación @Autowired, Spring busca una coincidencia en el contexto de la aplicación para la clase que debe inyectarse y proporciona la instancia adecuada. Si hay múltiples coincidencias, Spring arrojará una excepción a menos que especifiques cómo se debe manejar la inyección de dependencias ambiguas.

  Es importante mencionar que, a partir de Spring Framework 4.3, @Autowired se volvió opcional para los constructores si solo hay un constructor en la clase. Esto significa que si tienes un solo constructor, Spring intentará inyectar automáticamente las dependencias sin necesidad de la anotación @Autowired. Sin embargo, todavía puedes usar @Autowired si lo deseas para mayor claridad o si tienes múltiples constructores.