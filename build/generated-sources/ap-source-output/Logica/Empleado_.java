package Logica;

import Logica.Cargo;
import Logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-19T11:21:09")
@StaticMetamodel(Empleado.class)
public class Empleado_ extends Persona_ {

    public static volatile SingularAttribute<Empleado, Cargo> idCargo;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;

}