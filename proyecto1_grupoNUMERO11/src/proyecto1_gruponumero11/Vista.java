/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1_gruponumero11;
import modelo.*;
import modelo2.*;
import entidades.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ivand
 */
public class Vista {
    private static final LocalDate fechaActual = LocalDate.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String fechaFormateada = fechaActual.format(formatter);
    /**
     * @param args the command line arguments
     */
    
    public static Scanner sc= new Scanner(System.in);
    public static ArrayList<TransaccionFinanciera> listaTransaccionFinanciera; 
    public static ArrayList<Categoria> listaCategorias; 
    public static ArrayList<ProcesoBancario> listaProcesosBancarios;
    public static ArrayList<Entidad> listaEntidades;
    public void administrarCategorias(){
        int opcion=0;
        while(opcion!=3){
            System.out.println("////////////////////////////////////////////////////////////////");
            System.out.println("Categorias disponibles ingresos");
            int contadorI=1;
            int contadorG=1;

            for(Categoria categoria:listaCategorias){
                if (categoria.getTipoCategoria().equals(TipoCategoria.INGRESO)){

                    System.out.println(contadorI+". "+ categoria.getNombre());
                    contadorI+=1;

                }

            }
            System.out.println("Categorias disponibles gastos");

            for(Categoria categoria:listaCategorias){
                if (categoria.getTipoCategoria().equals(TipoCategoria.GASTO)){ 
                    System.out.println(contadorG+". "+categoria.getNombre());
                    contadorG+=1;
                }

                
            }
            System.out.println("////////////////////////////////////////////////////////////////");
            
            System.out.println("Opciones:\n\n1. Agregar Categoria\n2. Eliminar Categoria\n3. Regresar al Menu principal\nIngrese un numero");
            opcion= sc.nextInt();
            sc.nextLine();
            System.out.println("////////////////////////////////////////////////////////////////");
            String tipo;
            String nombre;
            TipoCategoria tipoCategoria;
            Categoria categoria;
            Iterator<Categoria> iterator;
            boolean categoriaExistente;
            switch (opcion){
            case 1:
                System.out.println("Ingrese el tipo de categoria (Ingreso/Gasto): ");
                tipo=sc.nextLine().toUpperCase();
                System.out.println("Ingrese el nombre de la categoria: ");
                nombre=sc.nextLine();
                tipoCategoria = TipoCategoria.valueOf(tipo);
                categoria=new Categoria(tipoCategoria,nombre);
                
                iterator= listaCategorias.iterator();
                
                categoriaExistente= false;
                
                while (iterator.hasNext()) {
                    Categoria cat = iterator.next();
                        if (cat.getNombre().equals(categoria.getNombre())) {
                            System.out.println("Nombre ya registrado");
                            categoriaExistente = true;
                            break; 
                        }
                }

                if (!categoriaExistente) {
                    listaCategorias.add(categoria);
                     System.out.println("Categoría agregada correctamente.");
                }
                break;
                
            case 2:
                System.out.println("Ingrese el tipo de categoria (Ingreso/Gasto): ");
                tipo=sc.nextLine().toUpperCase();
                System.out.println("Ingrese el nombre de la categoria: ");
                nombre=sc.nextLine();
                tipoCategoria = TipoCategoria.valueOf(tipo);
                
                iterator= listaCategorias.iterator();
                
                categoriaExistente= false;
                
                while (iterator.hasNext()) {
                    Categoria cat = iterator.next();
                    
                    if (cat.getNombre().equals(nombre)) {
                        System.out.println("Desea eliminar "+cat.getNombre()+"?  yes/no"
                        );
                        String confirmacion=sc.nextLine();
                        if (confirmacion.equals("yes")){
                        
                            iterator.remove(); 
                            categoriaExistente = true;
                            System.out.println("Categoría " + nombre + " eliminada.");
                        }else if(confirmacion.equals("no")){
                            System.out.println("no se elimino "+cat.getNombre());
                            categoriaExistente = true;
                        }
                        
                    }
                }
                if (!categoriaExistente) {
                    
                    System.out.println("Categoría " + nombre + " no existe ");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Numero no valido");
                break;
            }
            
        }
        
        
        
    }
    
    public void administrarIngresos(){
        int opcion=0;
        
        while (opcion!=4){
            System.out.printf("%-10s %-30s %-15s %-15s %-15s %-15s %-15s","Codigo","Descripcion","Valor", "Fecha inicio","Fecha fin","Categoria","Repeticion");
            System.out.println("");        
            for(TransaccionFinanciera transaccion:listaTransaccionFinanciera){

                if(transaccion instanceof Ingreso){
                    Ingreso ing= (Ingreso)transaccion;
                    System.out.println(ing.mostrarInformacion());
                }

            }
            //Opciones menu administrar ingresos
        
            System.out.println("////////////////////////////////////////////");
            System.out.println("Opciones:");
            System.out.println("1 Registrar Ingreso");
            System.out.println("2 Eliminar Ingreso");
            System.out.println("3 Finalizar Ingreso");
            System.out.println("4 Regresar Menu principal");
            System.out.println("Ingrese una opcion:");
            opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese una categoria ya registrada");
                    String categoria=sc.nextLine();
                    
                    Categoria categoriaSeleccionada=null; 
                    for(Categoria cat: listaCategorias){
                       
                        if(cat.getNombre().equals(categoria)){
                           categoriaSeleccionada= cat;

                        }
                        
                    }
                    if(categoriaSeleccionada != null){
                        System.out.println("Ingrese un valor");
                            double valor= sc.nextDouble();
                            sc.nextLine();
                            System.out.println("ingrese una descripcion");
                            String descripcion=sc.nextLine();
                            System.out.println("ingrese la fecha del inicio del Ingreso");
                            String fechaInicio=sc.nextLine();
                            System.out.println("ingrese la repeticion del ingreso");
                            String repeticion=sc.nextLine();
                            System.out.println("ingrese la fecha del fin del Ingreso");
                            String fechaFin=sc.nextLine();
                            Ingreso ingreso=new Ingreso(descripcion,valor,fechaInicio,fechaFin,categoriaSeleccionada,repeticion);
                            listaTransaccionFinanciera.add(ingreso);
                    
                    }else {
                    System.out.println("Categoría no encontrada.");
                }
                break;
                
                case 2:
                    System.out.println("ingrese el codigo del Ingreso a eliminar");
                    int codigo=sc.nextInt();
                    sc.nextLine();
                    Iterator<TransaccionFinanciera> iterator=listaTransaccionFinanciera.iterator();
                    
                    boolean encontrado= false;
                    
                   while(iterator.hasNext()){
                       TransaccionFinanciera transaccion=iterator.next();
                       if(transaccion instanceof Ingreso){
                           Ingreso ingreso=(Ingreso)transaccion;
                           if (ingreso.getCodigo()==codigo) {
                               System.out.println("Desea eliminar yes/no");
                               String confirmacion=sc.nextLine();
                               if(confirmacion.equals("yes")){
                                    iterator.remove();
                                    encontrado= true;
                                    System.out.println("Ingreso eliminado exitosamente");
                                    break;
                               }else{
                                    encontrado= true;
                                    System.out.println("Ingreso no eliminado");
                                    break;
                                }
                           }
                            
                           
                       }
                   }
                    if (!encontrado) {
                        System.out.println("Ingreso no encontrado.");
                    }
                    break;
                
                case 3:
                    System.out.println("Ingrese el codigo del Ingreso que desea finalizar");
                    int codigoCase3=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la fecha final a modificar en el formato dd/mm/aaaa");
                    String fechaFin=sc.nextLine();
                    Iterator<TransaccionFinanciera> iteratorCase3=listaTransaccionFinanciera.iterator();
                    
                    boolean encontradoCase3= false;

                    while(iteratorCase3.hasNext()){
                       TransaccionFinanciera transaccion=iteratorCase3.next();
                       
                        if (transaccion instanceof Ingreso) {
                            if (transaccion.getCodigo() == codigoCase3) {
                                encontradoCase3 = true;
                                Ingreso ingreso = (Ingreso) transaccion;
                                if (transaccion.esFechaMayor(fechaFin, ingreso.getFechaInicio())) {
                                    ingreso.setFechaFin(fechaFin);
                                    System.out.println("Fecha final del ingreso actualizada exitosamente.");
                                    System.out.println("////////////////////////////////////////////");
                                } else {
                                    System.out.println("La fecha de fin no es mayor que la fecha de inicio.");
                                    System.out.println("////////////////////////////////////////////");
                                }
                                break;  // Salir del bucle una vez que se encuentra y procesa el ingreso
                            }
                        }
                    }

                    if (!encontradoCase3) {
                        System.out.println("No se ha encontrado un ingreso con el código proporcionado.");
                        System.out.println("////////////////////////////////////////////");
                    }
                    break;
                    
                default:
                    System.out.println("Numero no valido ");
                    break;
              

            }

        }
        

        
    }
        
    public void administrarGastos(){
        int opcion=0;
        
        while (opcion!=4){
            System.out.printf("%-10s %-30s %-15s %-15s %-15s %-15s %-15s","Codigo","Descripcion","Valor", "Fecha inicio","Fecha fin","Categoria","Repeticion");
            System.out.println("");        
            for(TransaccionFinanciera transaccion:listaTransaccionFinanciera){

                if(transaccion instanceof Gasto){
                    Gasto gasto = (Gasto)transaccion;
                    System.out.println(gasto.mostrarInformacion());
                }

            }
            //Opciones menu administrar ingresos
        
            System.out.println("////////////////////////////////////////////");
            System.out.println("Opciones:");
            System.out.println("1 Registrar Gasto");
            System.out.println("2 Eliminar Gasto");
            System.out.println("3 Finalizar Gasto");
            System.out.println("4 Regresar Menu principal");
            System.out.println("Ingrese una opcion:");
            opcion= sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese una categoria ya registrada");
                    String categoria=sc.nextLine();
                    
                    Categoria categoriaSeleccionada=null; 
                    for(Categoria cat: listaCategorias){
                        if(cat.getNombre().equals(categoria)){
                            
                            categoriaSeleccionada= cat;
                        
                        }
                        
                    }
                    if(categoriaSeleccionada != null){
                        System.out.println("Ingrese un valor");
                            double valor= sc.nextDouble();
                            sc.nextLine();
                            System.out.println("ingrese una descripcion");
                            String descripcion=sc.nextLine();
                            System.out.println("ingrese la fecha del inicio del Ingreso");
                            String fechaInicio=sc.nextLine();
                            System.out.println("ingrese la repeticion del ingreso");
                            String repeticion=sc.nextLine();
                            System.out.println("ingrese la fecha del fin del Ingreso");
                            String fechaFin=sc.nextLine();
                            Gasto gasto=new Gasto(descripcion,valor,fechaInicio,fechaFin,categoriaSeleccionada,repeticion);
                            listaTransaccionFinanciera.add(gasto);
                    
                    }else {
                    System.out.println("Categoría no encontrada.");
                }
                break;
                
                case 2:
                    System.out.println("ingrese el codigo del Gasto a eliminar");
                    int codigo=sc.nextInt();
                    sc.nextLine();
                    Iterator<TransaccionFinanciera> iterator=listaTransaccionFinanciera.iterator();
                    
                    boolean encontrado= false;
                    
                    while(iterator.hasNext()){
                       TransaccionFinanciera transaccion=iterator.next();
                       if(transaccion instanceof Gasto){
                           Gasto gasto=(Gasto)transaccion;
                           if (gasto.getCodigo()==codigo) {
                               System.out.println("Desea eliminar yes/no");
                               String confirmacion=sc.nextLine();
                               if(confirmacion.equals("yes")){
                                    iterator.remove();
                                    encontrado= true;
                                    System.out.println("Gasto eliminado exitosamente");
                                    break;
                               }else{
                                    encontrado= true;
                                    System.out.println("Gasto no eliminado");
                                    break;
                                }
                           }
                            
                           
                       }
                   }
                    if (!encontrado) {
                        System.out.println("Gasto no encontrado.");
                    }
                    break;
                
                case 3:
                    System.out.println("Ingrese el codigo del Gasto que desea finalizar");
                    int codigoCase3=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la fecha final a modificar en el formato dd/mm/aaaa");
                    String fechaFin=sc.nextLine();
                    Iterator<TransaccionFinanciera> iteratorCase3=listaTransaccionFinanciera.iterator();
                    
                    boolean encontradoCase3= false;

                    while(iteratorCase3.hasNext()){
                       TransaccionFinanciera transaccion=iteratorCase3.next();
                       
                        if (transaccion instanceof Gasto) {
                            if (transaccion.getCodigo() == codigoCase3) {
                                encontradoCase3 = true;
                                Gasto gasto = (Gasto) transaccion;
                                if (transaccion.esFechaMayor(fechaFin, gasto.getFechaInicio())) {
                                    gasto.setFechaFin(fechaFin);
                                    System.out.println("Fecha final del gasto actualizada exitosamente.");
                                    System.out.println("////////////////////////////////////////////");
                                } else {
                                    System.out.println("La fecha de fin no es mayor que la fecha de inicio.");
                                    System.out.println("////////////////////////////////////////////");
                                }
                                break;  // Salir del bucle una vez que se encuentra y procesa el ingreso
                            }
                        }
                    }

                    if (!encontradoCase3) {
                        System.out.println("No se ha encontrado un gasto con el código proporcionado.");
                        System.out.println("////////////////////////////////////////////");
                    }
                    break;
                    
                default:
                    System.out.println("Numero no valido ");
                    break;
              

            }
            
            
            
        }
    
    
    
    }
    
    public void cuentasPorCobrar(){
        int opcion=0;
        while(opcion!=2){
            System.out.printf("%-15s %-15s %-15s %-30s %-20s %-15s","Codigo","Deudor","Valor","Descripcion","Fecha de prestamo","Cuota");
            System.out.println("");        
            for(TransaccionFinanciera transaccion:listaTransaccionFinanciera){

                if(transaccion instanceof Prestamo){
                    Prestamo prestamo = (Prestamo)transaccion;
                    System.out.println(prestamo.mostrarInformacion());
                }

            }
            System.out.println("Opciones");
            System.out.println("1 Registrar Prestamo");
            System.out.println("2 Regresar al Menu Principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el numero de cedula");
                    String nCedula= sc.nextLine();
                    Persona deudor=null;
                    boolean personaEncontrada=false;
                    for(TransaccionFinanciera tra: listaTransaccionFinanciera){
                        if (tra instanceof Prestamo){
                            Prestamo prestamo=(Prestamo)tra;
                            if(prestamo.getDeudor().getNumeroIdentidad().equals(nCedula)){
                                deudor=prestamo.getDeudor();
                                personaEncontrada= true;
                                break;
                            }
                                
                           
                            
                            
                        }
                    
                   
                    
                    }
                    if(!personaEncontrada){
                        System.out.println("Persona no registrada");
                        System.out.println("Ingrese su cedula: ");
                        String cedula=sc.nextLine();
                        System.out.println("Ingrese su nombre: ");
                        String nombre= sc.nextLine();
                        System.out.println("Ingrese su telefono: ");
                        String telefono=sc.nextLine();
                        System.out.println("Ingrese su email: ");
                        String email=sc.nextLine();
                        deudor= new Persona(nombre,email,cedula,telefono,fechaFormateada);
                            
                    
                    
                    
                    }
                    
                    
                    System.out.println("Ingrese el Valor");
                    double valor=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese la descripcion");
                    String descripcion =sc.nextLine();
                    System.out.println("Ingrese la fecha de prestamo");
                    String fechaDePrestamo =sc.nextLine();
                    System.out.println("Ingrese la cuota de prestamo");
                    int cuota=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la fecha de inicio de pago");
                    String fechaInicio =sc.nextLine();
                    System.out.println("Ingrese la fecha de finalizacion de pago");
                    
                    String fechaFin =sc.nextLine();
                    
                    Prestamo prestamo= new Prestamo(descripcion,valor,fechaInicio,fechaFin,deudor,fechaDePrestamo,cuota);
                    
                    while(true){    
                        if (prestamo.esFechaMayor(fechaFin,fechaInicio)) {
                            
                             break;
                        } else {
                            System.out.println("La fecha de fin no es mayor que la fecha de inicio.");
                            System.out.println("Ingrese una nueva fecha final");
                            fechaFin=sc.nextLine();
                            System.out.println("////////////////////////////////////////////");
                            
                            prestamo.setFechaFin(fechaFin);
                        
                        }
                    }
                    
                    listaTransaccionFinanciera.add(prestamo);
                    break;
                default: 
                    System.out.println("No ingreso una opcion valida");
                    break;
            }
        
        }
    
    }
    
    public void cuentasPorPagar(){
        int opcion=0;
        while(opcion!=2){
            System.out.printf("%-15s %-20s %-15s %-30s %-20s %-15s","Codigo","Acredor","Valor","Descripcion","Fecha de prestamo","Cuota");
            System.out.println("");        
            for(TransaccionFinanciera transaccion:listaTransaccionFinanciera){

                if(transaccion instanceof Pago){
                    Pago pago = (Pago)transaccion;
                    System.out.println(pago.mostrarInformacion());
                }

            }
            System.out.println("Opciones");
            System.out.println("1 Registrar Pago");
            System.out.println("2 Regresar al Menu Principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el numero de identidad");
                    String nIdentidad= sc.nextLine();
                    Entidad acredor=null;
                    boolean entidadEncontrada=false;
                    for(TransaccionFinanciera tra: listaTransaccionFinanciera){
                        if (tra instanceof Pago){
                            Pago pago=(Pago)tra;
                            if(pago.getEntidad().getNumeroIdentidad().equals(nIdentidad)){
                                acredor=pago.getEntidad();
                                entidadEncontrada= true;
                                break;
                            }
                                
                           
                            
                            
                        }
                    
                   
                    
                    }
                    if(!entidadEncontrada){
                        System.out.println("Entidad no registrada");
                        System.out.println("Ingrese su cedula/ruc: ");
                        String id=sc.nextLine();
                        System.out.println("Ingrese su nombre: ");
                        String nombre= sc.nextLine();
                        System.out.println("Ingrese su email: ");
                        String email=sc.nextLine();
                        System.out.println("Es Persona o Banco p/b");
                        String tipo=sc.nextLine();
                        
                        if(tipo.equals("p")){
                            
                            System.out.println("Ingrese su telefono: ");
                            String telefono=sc.nextLine();
                            
                            acredor= new Persona(nombre,email,id,telefono,fechaFormateada);
                        }else if(tipo.equals("b")){
                            System.out.println("Ingrese el nombre del oficial de credito ");
                            String nombreOficialCredito=sc.nextLine();
                            System.out.println("Ingrese el telefono del oficial de credito ");
                            String telefonoOficialCredito=sc.nextLine();
                            
                            acredor=new Banco(nombre,email,id,fechaFormateada,nombreOficialCredito,telefonoOficialCredito);
                        }   
                    
                    
                    
                    }
                    
                    
                    System.out.println("Ingrese el Valor");
                    double valor=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese el interes con el que se adquirio la deuda");
                    double interes=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese la descripcion");
                    String descripcion =sc.nextLine();
                    System.out.println("Ingrese la fecha de prestamo");
                    String fechaDePrestamo =sc.nextLine();
                    System.out.println("Ingrese la cuota de prestamo");
                    int cuota=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la fecha de inicio de pago");
                    String fechaInicio =sc.nextLine();
                    System.out.println("Ingrese la fecha de finalizacion de pago");
                    
                    String fechaFin =sc.nextLine();
                    
                    Pago pago= new Pago(descripcion,valor,fechaInicio,fechaFin,acredor,interes,fechaDePrestamo,cuota);
                    
                    while(true){    
                        if (pago.esFechaMayor(fechaFin,fechaInicio)) {
                            
                             break;
                        } else {
                            System.out.println("La fecha de fin no es mayor que la fecha de inicio.");
                            System.out.println("Ingrese una nueva fecha final");
                            fechaFin=sc.nextLine();
                            System.out.println("////////////////////////////////////////////");
                            
                            pago.setFechaFin(fechaFin);
                        
                        }
                    }
                    
                    listaTransaccionFinanciera.add(pago);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            
            }
        }
        
        
    }
    
    public void administrarCuentasBancarias(){
        
        int opcion=0;
        while (opcion!= 4){
            System.out.printf("%-10s %-30s %-15s %-15s %-15s","Codigo","Entidad Bancaria","Tipo","Numero","Saldo");
            System.out.println("");
            for(ProcesoBancario procesoBancario:listaProcesosBancarios){

                if(procesoBancario instanceof CuentaBancaria){
                    CuentaBancaria cuentaBancaria = (CuentaBancaria)procesoBancario;
                    System.out.println(cuentaBancaria.mostrarInformacion());
                }

            }
            System.out.println("Opciones");
            System.out.println("1 Registrar cuenta");
            System.out.println("2 Eliminar cuenta");
            System.out.println("3 Cerrar cuenta");
            System.out.println("4 Regresar al Menu principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                    boolean existeBanco= false;
                    
                    System.out.println("Ingrese el nombre o ruc de la entidad bancaria");
                    String identificador=sc.nextLine();
                    Banco bancoEncontrado= null;
                    
                    TipoCuenta tipoCuenta=null;
                    if (!existeBanco){
                        for(Entidad entidad: listaEntidades){
                            if(entidad instanceof Banco){
                                Banco banco= (Banco)entidad;
                                if(banco.getNombre().equals(identificador)||banco.getNumeroIdentidad().equals(identificador)){
                                    existeBanco= true;
                                    bancoEncontrado= banco;
                                    
                                }

                            }
                        }
                    }
                    if (existeBanco){
                        System.out.println("Ingrese el numero del banco");
                        String numero=sc.nextLine();
                        System.out.println("Ingrese el tipo de cuenta, Ahorro/Corriente");
                        String tipo=sc.nextLine();
                        
                        try {
                            tipoCuenta= TipoCuenta.valueOf(tipo.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Tipo de cuenta ingresado inválido.");
                        }
                        System.out.println("Ingrese la fecha de apertura");
                        String fechaApertura= sc.nextLine();
                        System.out.println("Ingrese el saldo");
                        double saldo=sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Ingrese el interes aproximado ganado en el mes");
                        double interes=sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingrese la fecha del cierre de la cuenta");
                        String fechaCierre=sc.nextLine();
                        
                        CuentaBancaria cuentaBancaria= new CuentaBancaria(bancoEncontrado,fechaApertura,interes,fechaCierre,tipoCuenta,numero,saldo);
                        listaProcesosBancarios.add(cuentaBancaria);
                        break;
                    }
                    
                case 2:
                    System.out.println("Ingrese el código de la cuenta:");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    Iterator<ProcesoBancario> iterator = listaProcesosBancarios.iterator();

                    boolean cuentaEncontrada = false;
                    while (iterator.hasNext()) {
                        ProcesoBancario procesoBancario = iterator.next();

                        if (procesoBancario instanceof CuentaBancaria) {
                            CuentaBancaria cuentaBancaria = (CuentaBancaria) procesoBancario;
                            if (cuentaBancaria.getCodigo() == codigo) {
                                cuentaEncontrada = true;
                                System.out.println("¿Desea continuar? yes/no");
                                String confirmacion = sc.nextLine();

                                if (confirmacion.equalsIgnoreCase("yes")) {
                                    iterator.remove();
                                    System.out.println("La cuenta ha sido eliminada.");
                                } else if (confirmacion.equalsIgnoreCase("no")) {
                                    System.out.println("Su cuenta no ha sido eliminada.");
                                } else {
                                    System.out.println("Ingresó una opción no válida.");
                                }
                                break;
                            }
                        }
                    }

                    if (!cuentaEncontrada) {
                        System.out.println("No se encontró una cuenta con el código proporcionado.");
                    }break;
                case 3:
                    System.out.println("ingrese el codigo de la cuenta que desea finalizar");
                    int codigo1= sc.nextInt();
                    sc.nextLine();
                    for(ProcesoBancario procesoBancario:listaProcesosBancarios){

                        if(procesoBancario instanceof CuentaBancaria){
                            CuentaBancaria cuentaBancaria = (CuentaBancaria)procesoBancario;
                            if (cuentaBancaria.getCodigo()==codigo1){
                                System.out.println("Ingrese la fecha de cierre");
                                String fechaCierre=sc.nextLine();
                               if( TransaccionFinanciera.esFechaMayor(fechaCierre, cuentaBancaria.getFechaApertura())){
                                   cuentaBancaria.setFechaCierre(fechaCierre);
                               
                               }else {
                                   System.out.println("La fecha de cierre no es mayor a la fecha de apertura");
                               }
                            
                            }    
                        }
                       

                    }
                    
                    break;
            
                default:
                    System.out.println("opcion no valida");
            
            
            }
            
        }
    }
    
    public void administrarInversiones(){
        int opcion=0;
        while (opcion!= 4){
            System.out.printf("%-10s %-30s %-15s %-15s %-15s %-15s","Codigo","Entidad Bancaria","Fecha apertura","cantidad","Interes mensual","fecha finalizacion");
            System.out.println("");
            for(ProcesoBancario procesoBancario:listaProcesosBancarios){

                if(procesoBancario instanceof Inversion){
                    Inversion inversion = (Inversion)procesoBancario;
                    System.out.println(inversion.mostrarInformacion());
                }

            }
            
            System.out.println("Opciones");
            System.out.println("1 Registrar cuenta");
            System.out.println("2 Eliminar cuenta");
            System.out.println("3 Cerrar cuenta");
            System.out.println("4 Regresar al Menu principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                    boolean existeBanco= false;
                    
                    System.out.println("Ingrese el nombre o ruc de la entidad bancaria");
                    String identificador=sc.nextLine();
                    Banco bancoEncontrado= null;
                    
                    
                    if (!existeBanco){
                        for(Entidad entidad: listaEntidades){
                            if(entidad instanceof Banco){
                                Banco banco= (Banco)entidad;
                                if(banco.getNombre().equals(identificador)||banco.getNumeroIdentidad().equals(identificador)){
                                    existeBanco= true;
                                    bancoEncontrado= banco;
                                    
                                }

                            }
                        }
                    }
                    if (existeBanco){
                  
                        System.out.println("Ingrese la fecha de apertura");
                        String fechaApertura= sc.nextLine();
                        System.out.println("Ingrese la cantidad a invertir");
                        double cantidad=sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Ingrese el interes aproximado ganado en el mes");
                        double interes=sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingrese la fecha del cierre de la cuenta");
                        String fechaCierre=sc.nextLine();
                        
                        Inversion inversion= new Inversion(bancoEncontrado,fechaApertura,interes,fechaCierre,cantidad);
                        listaProcesosBancarios.add(inversion);
                        break;
                    }
                    
                case 2:
                    System.out.println("Ingrese el código de la cuenta:");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    Iterator<ProcesoBancario> iterator = listaProcesosBancarios.iterator();

                    boolean cuentaEncontrada = false;
                    while (iterator.hasNext()) {
                        ProcesoBancario procesoBancario = iterator.next();

                        if (procesoBancario instanceof Inversion) {
                            Inversion inversion = (Inversion) procesoBancario;
                            if (inversion.getCodigo() == codigo) {
                                cuentaEncontrada = true;
                                System.out.println("¿Desea continuar? yes/no");
                                String confirmacion = sc.nextLine();

                                if (confirmacion.equalsIgnoreCase("yes")) {
                                    iterator.remove();
                                    System.out.println("La cuenta ha sido eliminada.");
                                } else if (confirmacion.equalsIgnoreCase("no")) {
                                    System.out.println("Su cuenta no ha sido eliminada.");
                                } else {
                                    System.out.println("Ingresó una opción no válida.");
                                }
                                break;
                            }
                        }
                    }

                    if (!cuentaEncontrada) {
                        System.out.println("No se encontró una cuenta con el código proporcionado.");
                    }break;
                case 3:
                    System.out.println("ingrese el codigo de la cuenta que desea finalizar");
                    int codigo1= sc.nextInt();
                    sc.nextLine();
                    for(ProcesoBancario procesoBancario:listaProcesosBancarios){

                        if(procesoBancario instanceof Inversion){
                            Inversion inversion = (Inversion)procesoBancario;
                            if (inversion.getCodigo()==codigo1){
                                System.out.println("Ingrese la fecha de cierre");
                                String fechaCierre=sc.nextLine();
                               if( TransaccionFinanciera.esFechaMayor(fechaCierre, inversion.getFechaApertura())){
                                   inversion.setFechaCierre(fechaCierre);
                               
                               }else {
                                   System.out.println("La fecha de cierre no es mayor a la fecha de apertura");
                               }
                            
                            }    
                        }
                       

                    }
                    
                    break;
            
                default:
                    System.out.println("opcion no valida");
   
            }
            
        }
    
    }
    
    public void administrarPersonasBancos(){
        int opcion=0;
        while (opcion!=3){
            System.out.printf("%-10s %-15s %-20s %-25s %-25s %-15s","Codigo","Fecha registro","Identificacion","Nombre","Email","Otros datos");
            System.out.println("");
            for(Entidad entidad: listaEntidades){
                System.out.println(entidad.mostrarInformacion());
            }
            System.out.println("Opciones");
            System.out.println("1 Registrar Persona/Banco");
            System.out.println("2 Eliminar ");
            System.out.println("3 Regresar al Menu principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Registrar Persona o Banco ingrese: p/b");
                    String ingreso=sc.nextLine();
                    
                    if(ingreso.equals("p")){
                        System.out.println("Ingrese su cedula");
                        String cedula=sc.nextLine();
                        System.out.println("Ingrese su nombre");
                        String nombre=sc.nextLine();
                        System.out.println("Ingrese su telefono");
                        String telefono=sc.nextLine();
                        System.out.println("Ingrese su email");
                        String email=sc.nextLine();
                        
                        Persona persona=new Persona(nombre,email,cedula,fechaFormateada,telefono);
                        listaEntidades.add(persona);
                        
                    }else if(ingreso.equals("b")){
                        System.out.println("Ingrese el ruc del banco");
                        String cedula=sc.nextLine();
                        System.out.println("Ingrese el nombre del banco");
                        String nombre=sc.nextLine();
                        System.out.println("Ingrese el telefono del banco");
                        String telefono=sc.nextLine();
                        System.out.println("Ingrese el email del banco");
                        String email=sc.nextLine();
                        System.out.println("Ingrese el nombre de oficial de credito");
                        String nombreOficialCredito=sc.nextLine();
                        System.out.println("Ingrese el telefono del oficial de credito");
                        String telefonooficialCredito=sc.nextLine();
                        
                        
                        Banco banco=new Banco(nombre,email,cedula,fechaFormateada,nombreOficialCredito,telefonooficialCredito);
                        listaEntidades.add(banco);
                        
                    }else{
                        System.out.println("Ingreso una opcion no valido");
                        break;
                    }
                    
                    break;
                case 2:
                    System.out.println("Ingrese un número de cédula/RUC:");
                    String cedula = sc.nextLine();
                    boolean confirmacionGeneral= false;
                    Iterator<Entidad> iterator = listaEntidades.iterator();
                    while (iterator.hasNext()) {
                        Entidad entidad = iterator.next();
                        if (entidad.getNumeroIdentidad().equals(cedula)) {
                            System.out.println("¿Desea eliminar el registro de " + entidad.getNombre() + "? yes/no");
                            String confirmacion = sc.nextLine();
                            if (confirmacion.equalsIgnoreCase("yes")) {
                                iterator.remove();
                                confirmacionGeneral=true;
                                
                                System.out.println("Registro eliminado.");
                            } else if (confirmacion.equalsIgnoreCase("no")) {
                                System.out.println("Registro no eliminado.");
                            }
                            break; // Salir del bucle después de encontrar la entidad
                        }
                    }
                     // Iterador para listaTransaccionFinanciera
                    if(confirmacionGeneral){
                        Iterator<TransaccionFinanciera> iterator2 = listaTransaccionFinanciera.iterator();
                        while (iterator2.hasNext()) {
                            TransaccionFinanciera transaccion = iterator2.next();
                            if(transaccion instanceof Prestamo){
                                Prestamo prestamo=(Prestamo) transaccion;
                                if (prestamo.getDeudor().getNumeroIdentidad().equals(cedula)) {
                                    iterator2.remove();
                                    break; // Salir del bucle después de encontrar la transacción
                                }
                            }
                        }
                    }
                    if(confirmacionGeneral){
                        Iterator<TransaccionFinanciera> iterator4 = listaTransaccionFinanciera.iterator();
                        while (iterator4.hasNext()) {
                            TransaccionFinanciera transaccion = iterator4.next();
                            if(transaccion instanceof Pago){
                                Pago pago=(Pago) transaccion;
                                if (pago.getEntidad().getNumeroIdentidad().equals(cedula)) {
                                    iterator4.remove();
                                    break; // Salir del bucle después de encontrar la transacción
                                }
                            }
                        }
                    }
                    
                    // Iterador para listaProcesosBancarios
                    if(confirmacionGeneral){
                        Iterator<ProcesoBancario> iterator3 = listaProcesosBancarios.iterator();
                        while (iterator3.hasNext()) {
                            ProcesoBancario proceso = iterator3.next();
                            if(proceso instanceof Inversion){
                                Inversion inversion=(Inversion) proceso;

                                    if (inversion.getBanco().getNumeroIdentidad().equals(cedula)) {
                                        iterator3.remove();

                                        break; // Salir del bucle después de encontrar el proceso
                                    }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            
            }
            
            
        }
        
    
    
    }
    
    public void reportes(){
        
        int opcion=0;
        while(opcion!=3){
            System.out.println("Opciones");
            System.out.println("1 Reportes de ingresos");
            System.out.println("2 Reportes de gasros ");
            System.out.println("3 Regresar al Menu principal");
            System.out.println("\nIngrese una opcion:");
            opcion=sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Seleccionar Periodo:");
                    System.out.println("1 Mes actual");
                    System.out.println("2 Año");
                    System.out.println("Elija una opcion");
                    int eleccion=sc.nextInt();
                    sc.nextLine();
                    
                    
                    switch (eleccion){
                        case 1:
                        for(TransaccionFinanciera tf:listaTransaccionFinanciera){
                            
                            if(tf instanceof Ingreso){
                                Ingreso ingreso =(Ingreso)tf;
                                System.out.println(ingreso.mostrarReporte());
                            }

                        }break;
                        case 2:
                            break;
                        default: 
                            System.out.println("Ingreso una opcion no valida");
                    }
                    break;
        
            }
        }
    
    }
    
    
     
    
    public static void main(String[] args) {
       
    
        // Categorias de tipo gasto cargadas
        Categoria categoria1 = new Categoria(TipoCategoria.GASTO, "Alquiler");
        Categoria categoria2 = new Categoria(TipoCategoria.GASTO, "Transporte");
        // Categorias de tipo ingreso cargadas
        Categoria categoria3 = new Categoria(TipoCategoria.INGRESO, "Salario");
        Categoria categoria4 = new Categoria(TipoCategoria.INGRESO, "Premios");

        // Ingresos cargados
        Ingreso ingreso1 = new Ingreso("sueldo", 450.0, "01/07/2024", "00/00/0000", categoria3, "Mes");
        Ingreso ingreso2 = new Ingreso( "Premio obtenido en concurso", 100.0, "30/06/2025", "00/00/0000", categoria4, "Mes");

        // Gastos cargados
        Gasto gasto1 = new Gasto( "Alquiler casa", 350.0, "01/01/2024", "01/01/2024", categoria1, "Mes");
        Gasto gasto2 = new Gasto( "Expreso colegio", 1000.0, "01/04/2024", "30/01/2025", categoria2, "Mes");
        //Entidad cargada
        Persona persona1 = new Persona("Pedro Lopez","pedrolopez@espol.edu.ec","0952483931",fechaFormateada,"0959458667");
        Banco banco1= new Banco("Banco del Pacifico","BPacifico@gmail.com","09225465428001",fechaFormateada,"Juan R","0984562354");
        
        //Cuentas por cobrar/pagar  cargadas
        Prestamo prestamo1=new Prestamo("Sueldo",500.0,"00/00/0000","00/00/0000",persona1,"02/02/2024",50);
        Pago pago1=new Pago("Para la compra del auto",1500.0,"00/00/0000","00/00/0000",banco1,12,"02/02/2024",600);
        // Inversiones y cuenta Bancaria Cargadadas
        CuentaBancaria cuentaBancaria= new CuentaBancaria(banco1,"14/02/2024",25.0,"14/06/2026",TipoCuenta.AHORRO,"22223",255.0);
                
        Inversion inversion1 = new Inversion(banco1,"14/02/2002",23,"14/02/2024",5444.0);
        
        //Añadir elementos a la lista entidades
        listaEntidades= new ArrayList<>();
        listaEntidades.add(banco1);
        listaEntidades.add(persona1);

        //Añadir elementos a lista de procesos bancarios
        listaProcesosBancarios= new ArrayList<>();
        listaProcesosBancarios.add(inversion1);
        listaProcesosBancarios.add(cuentaBancaria);
        
        
        //Añadir elementos a lista de categorias
        listaCategorias= new ArrayList<>();
        listaCategorias.add(categoria1);
        listaCategorias.add(categoria2);
        listaCategorias.add(categoria3);
        listaCategorias.add(categoria4);
        
        // Añadir elementos a listaTransaccioFinanciera
        listaTransaccionFinanciera = new ArrayList<>();
        listaTransaccionFinanciera.add(gasto1);
        listaTransaccionFinanciera.add(gasto2);
        listaTransaccionFinanciera.add(ingreso1);
        listaTransaccionFinanciera.add(ingreso2);
        listaTransaccionFinanciera.add(prestamo1);
        listaTransaccionFinanciera.add(pago1);
        Vista v= new Vista();
         
        //Implementacion de menu;
        int numero=0;
        while(numero!=11){
            System.out.println("////////////////////////////////////////////////////////////////");
            System.out.println("bienvenido al sistema de control de finanzas personales");
            System.out.println("1 Administrar categorias");
            System.out.println("2 Administrar ingresos");
            System.out.println("3 Administrar Gastos");
            System.out.println("4 Cuentas por cobrar");
            System.out.println("5 Administrar cuentas por pagar");
            System.out.println("6 Administrar cuentas bancarias");
            System.out.println("7 Administrar Inversiones");
            System.out.println("8 Administrar personas y bancos");
            System.out.println("9 Reportes");
            System.out.println("10 Proyeccion de gastos");
            System.out.println("11 Salir");
            System.out.println("Ingrese  una opcion:");
            numero= sc.nextInt();
            sc.nextLine();
                switch(numero){
                    case 1: 

                        v.administrarCategorias();
                     break;
                    case 2:
                        v.administrarIngresos();
                        break;
                    case 3:
                        v.administrarGastos();
                        break;
                    case 4:
                        v.cuentasPorCobrar();
                        break;
                    case 5:
                        v.cuentasPorPagar();
                        break;
                    case 6:
                        v.administrarCuentasBancarias();
                        break;
                    case 7: 
                        v.administrarInversiones();
                        break;
                    case 8:
                        v.administrarPersonasBancos();
                        break;
                    case 9: 
                        v.reportes();

                    default:
                        System.out.println("numero no valido");

            }
        }
        
    }
}
    

