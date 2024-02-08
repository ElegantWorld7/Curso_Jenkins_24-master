package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Saldo {
    String curpAhorrador;
    double saldototal;
    double retiroimss97;
    double retiroimss92;
    double cvimss;
    double cuotasocialimss;
    double viviendaimss97;
    double viviendaimss92;
    double retiroissste92;
    double retiroissste08;
    double ahorrosolidario;
    double cvissste;
    double cuotasocialissste;
    double viviendaissste92;
    double viviendaissste2008;
    double bonopensionissste;
    double aportavoluntariascortoplazo;
    double complementariasretiro;
    double ahorrolargoplazo;
    double saldoentransito;
    String fechainicio;
    String fechafin;

    Saldo(String curpAhorrador) {
        this.curpAhorrador = curpAhorrador;
        this.saldototal = 146107.46;
        this.retiroimss97 = 15893.15;
        this.retiroimss92 = 0.0;
        this.cvimss = 36731.7;
        this.cuotasocialimss = 43493.6;
        this.viviendaimss97 = 86720.71;
        this.viviendaimss92 = 0.0;
        this.retiroissste92 = 0.0;
        this.retiroissste08 = 0.0;
        this.ahorrosolidario = 0.0;
        this.cvissste = 0.0;
        this.cuotasocialissste = 6761.9;
        this.viviendaissste92 = 0.0;
        this.viviendaissste2008 = 0.0;
        this.bonopensionissste = 0.0;
        this.aportavoluntariascortoplazo = 0.0;
        this.complementariasretiro = 0.0;
        this.ahorrolargoplazo = 0.0;
        this.saldoentransito = 0.0;
        this.fechainicio = "27/03/2023";
        this.fechafin = "27/07/2023";
    }
}

class Movimiento {
    String fecha;
    String descripcion;
    double importe;
    String tipo;

    Movimiento(String fecha, String descripcion, double importe, String tipo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.importe = importe;
        this.tipo = tipo;
    }
}

class RespuestaServicio {
    String resultadoOperacion = "01";
    List<Saldo> Saldos;
    List<Movimiento> Movimientos;

    RespuestaServicio(Saldo saldo, List<Movimiento> movimientos) {
        this.Saldos = new ArrayList<>();
        this.Saldos.add(saldo);
        this.Movimientos = movimientos;
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"resultadoOperacion\":\"").append(resultadoOperacion).append("\",");
        sb.append("\"Saldos\":[");
        for (Saldo saldo : Saldos) {
            sb.append("{");
            sb.append("\"curpAhorrador\":\"").append(saldo.curpAhorrador).append("\",");
            sb.append("\"saldototal\":").append(saldo.saldototal).append(",");
            sb.append("\"retiroimss97\":").append(saldo.retiroimss97).append(",");
            sb.append("\"retiroimss92\":").append(saldo.retiroimss92).append(",");
            sb.append("\"cvimss\":").append(saldo.cvimss).append(",");
            sb.append("\"cuotasocialimss\":").append(saldo.cuotasocialimss).append(",");
            sb.append("\"viviendaimss97\":").append(saldo.viviendaimss97).append(",");
            sb.append("\"viviendaimss92\":").append(saldo.viviendaimss92).append(",");
            sb.append("\"retiroissste92\":").append(saldo.retiroissste92).append(",");
            sb.append("\"retiroissste08\":").append(saldo.retiroissste08).append(",");
            sb.append("\"ahorrosolidario\":").append(saldo.ahorrosolidario).append(",");
            sb.append("\"cvissste\":").append(saldo.cvissste).append(",");
            sb.append("\"cuotasocialissste\":").append(saldo.cuotasocialissste).append(",");
            sb.append("\"viviendaissste92\":").append(saldo.viviendaissste92).append(",");
            sb.append("\"viviendaissste2008\":").append(saldo.viviendaissste2008).append(",");
            sb.append("\"bonopensionissste\":").append(saldo.bonopensionissste).append(",");
            sb.append("\"aportavoluntariascortoplazo\":").append(saldo.aportavoluntariascortoplazo).append(",");
            sb.append("\"complementariasretiro\":").append(saldo.complementariasretiro).append(",");
            sb.append("\"ahorrolargoplazo\":").append(saldo.ahorrolargoplazo).append(",");
            sb.append("\"saldoentransito\":").append(saldo.saldoentransito);
            sb.append(",\"fechainicio\":\"").append(saldo.fechainicio).append("\",");
            sb.append("\"fechafin\":\"").append(saldo.fechafin).append("\"");
            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1); // Elimina la última coma
        sb.append("],");
        sb.append("\"Movimientos\":[");
        for (Movimiento movimiento : Movimientos) {
            sb.append("{");
            sb.append("\"fecha\":\"").append(movimiento.fecha).append("\",");
            sb.append("\"descripcion\":\"").append(movimiento.descripcion).append("\",");
            sb.append("\"importe\":").append(movimiento.importe).append(",");
            sb.append("\"tipo\":\"").append(movimiento.tipo).append("\"");
            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1); // Elimina la última coma
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

}

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Por favor, proporciona el CURP del ahorrador como argumento.");
            return;
        }
        String curpAhorrador = args[0];
        Saldo saldo = new Saldo(curpAhorrador);
        List<Movimiento> movimientos = Arrays.asList(
            new Movimiento("30-MAR-23", "APORTACION", 1094.97, "2"),
            new Movimiento("30-MAR-23", "APORTACION", 2737.42, "2"),
            new Movimiento("03-ABR-23", "COMISION POR SALDO", 14.72, "1"),
            new Movimiento("25-MAY-23", "APORTACION", 1146.03, "2"),
            new Movimiento("03-JUL-23", "RENDIMIENTO BANXICO", 0.39, "2")
        );

        RespuestaServicio respuesta = new RespuestaServicio(saldo, movimientos);
        String jsonRespuesta = respuesta.toJson();
        System.out.println(jsonRespuesta);
    }
}
