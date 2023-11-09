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
* La anotación @Autowired en Spring se utiliza para inyectar automáticamente una dependencia en un bean.
 * Spring buscará un bean que coincida con el tipo de propiedad y lo inyectará automáticamente.



Un bean en Spring es un objeto que es instanciado, ensamblado y administrado por el contenedor de Spring. Los beans son definidos en un archivo XML o mediante anotaciones en una clase Java. Los beans son los componentes fundamentales de una aplicación Spring y son responsables de la lógica de negocio y el acceso a datos.
