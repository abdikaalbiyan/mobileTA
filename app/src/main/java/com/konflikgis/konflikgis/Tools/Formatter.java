package com.konflikgis.konflikgis.Tools;

public class Formatter {
    public static String timeStyle(int angka) {
        String toReturn = "";

        if(angka < 10) {
            toReturn = "0" + angka;
        } else {
            toReturn += angka;
        }

        return toReturn;
    }

    public static String namaBulanFromAngka(int angka) {
        String toReturn = "";

        switch (angka) {
            case 1:
                toReturn = "Januari";
                break;
            case 2:
                toReturn = "Februari";
                break;
            case 3:
                toReturn = "Maret";
                break;
            case 4:
                toReturn = "April";
                break;
            case 5:
                toReturn = "Mei";
                break;
            case 6:
                toReturn = "Juni";
                break;
            case 7:
                toReturn = "Juli";
                break;
            case 8:
                toReturn = "Agustus";
                break;
            case 9:
                toReturn = "September";
                break;
            case 10:
                toReturn = "Oktober";
                break;
            case 11:
                toReturn = "November";
                break;
            case 12:
                toReturn = "Desember";
                break;
            default:
                toReturn = "Bulan tidak ditemukan";
                break;
        }

        return toReturn;
    }
}
