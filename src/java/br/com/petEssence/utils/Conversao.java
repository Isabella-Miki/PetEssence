package br.com.petEssence.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Conversao {

    public static Date converterData(String data) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if (data == null || data.trim().equals("")) {
            return null;
        } else {
            Date date = fmt.parse(data);
            return date;
        }
    }

    public static String dataToString(Date data) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = fmt.format(data);
        return dataFormatada;
    }

    public static Date dataAtual() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = new Date(System.currentTimeMillis());
        return novaData;
    }
    
        public static LocalTime horaAtual() {
        return LocalTime.now();
    }

    public static double valorDinheiro(String valor) {
        String conversao = valor.substring(2, valor.length());
        conversao = conversao.replaceAll("[./-]", "");
        conversao = conversao.replace(",", ".").trim();
        return Double.parseDouble(conversao);
    }

    public static String valorDinheiro(double valor, String pais) {
        NumberFormat formatter = null;
        if (pais.equals("BR")) {
            formatter = NumberFormat.getCurrencyInstance();
        } else if (pais.equals("US")) {
            formatter = NumberFormat.getInstance(new Locale("en", "US"));
        }
        String moneyString = formatter.format(valor);
        return moneyString;
    }

    public static LocalTime converterHorario(String data) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = LocalTime.parse(data, formatter);
            System.out.println("Hora convertida: " + hora);
            return hora;
    }

    public static String horarioToString(Date data) {
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
        String horarioFormatado = fmt.format(data);
        return horarioFormatado;
    }
}
