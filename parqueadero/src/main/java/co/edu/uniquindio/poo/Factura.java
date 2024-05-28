package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Factura {

    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private LocalDateTime fecha;
    private Puesto puesto;

    /**
     * Metodo getPuesto
     * 
     * @return
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     * Metodo setPuesto
     * 
     * @param puesto
     */
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }


    /**
     * Metodo constructor de la clase factura
     * 
     * @param fechaIngreso
     * @param fechaSalida
     */
    public Factura(LocalDateTime fechaFactura, LocalDateTime horaSalida, double tarifaCarro,
            LocalDateTime horaIngreso, Puesto puesto) {
        this.fechaIngreso = horaIngreso;
        this.fechaSalida = horaSalida;

        this.puesto = puesto;

        while (!puesto.getEstado()) {
            System.out.println("El puesto está ocupado. No se puede crear la factura.");
            return;
        }

    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime horaIngreso) {
        this.fechaIngreso = horaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime horaSalida) {
        this.fechaSalida = horaSalida;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo DeterminarfraccionParqueado por horas o dias
     * 
     * @param horaIngreso
     * @param horaSalida
     * @return
     */
    public long fraccionParqueado(LocalDateTime horaIngreso, LocalDateTime horaSalida) {
        return ChronoUnit.HOURS.between(horaIngreso, horaSalida);
    }

    /**
     * Metodo para definir el costo a pagar de un vehiculo ya sea por horas o dias
     * 
     * @param horasDiferencia
     * @param tarifaCarro
     * @param tipoVehiculo
     * @return
     */
    public double definirCosto(double horasDiferencia, Vehiculo vehiculo) {

        double costo = 0.0;
        if (vehiculo instanceof Carro && horasDiferencia < 24) {
            costo = Carro.getTarifa() * horasDiferencia;
        } else if (vehiculo instanceof Carro && horasDiferencia > 24) {

            costo = (Carro.getTarifa() * (horasDiferencia / 24)) * 5;

        } else if (vehiculo instanceof Moto && horasDiferencia > 24) {
            TipoMoto tipoMoto = ((Moto) vehiculo).getTipoMoto();
            switch (tipoMoto) {
                case HIBRIDA:
                    costo = (Moto.getTarifa() * (horasDiferencia / 24)) * 5;
                    break;
                case CLASICA:
                    costo = (Moto.getTarifa() * (horasDiferencia / 24)) * 5;
                    break;

                default:

                    break;

            }
        } else if (vehiculo instanceof Moto && horasDiferencia < 24) {
            TipoMoto tipoMoto = ((Moto) vehiculo).getTipoMoto();
            switch (tipoMoto) {
                case HIBRIDA:
                    costo = Moto.getTarifa() * horasDiferencia;
                    break;
                case CLASICA:
                    costo = Moto.getTarifa()* horasDiferencia;
                    break;

                default:

                    break;

            }
        } else {

          }
          return costo;

    }

    /**
     * Metodo para calcular el costo a pagar del vehiculo segun lo estacionado
     * 
     * @param tarifaDia
     * @param tarifaHora
     * @param horasDiferencia
     * @return
     */
    public double calcularCosto(double tarifaDia, double tarifaHora, double horasDiferencia) {
        double costoTotal;
        if (horasDiferencia < 24) {
            costoTotal = horasDiferencia * tarifaHora;
        } else {
            costoTotal = (horasDiferencia / 24) * tarifaDia + (horasDiferencia % 24) * tarifaHora;
        }
        return costoTotal;
    }

    /**
     * Metodo para definirle un puesto a la factura donde el vehiculo esta ubicado
     * 
     * @param puesto
     */
    public void asignarPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

}
