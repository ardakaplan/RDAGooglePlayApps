package com.ardakaplan.rdagoogleplayapps;

import com.ardakaplan.rdagoogleplayappslib.RDAGooglePlayApplication;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan at 3/25/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class CreateAppJson {

    public static void main(String[] args) {

        System.out.print(new Gson().toJson(getLocalData()));
    }

    private static List<RDAGooglePlayApplication> getLocalData() {

        String iconRootFolder = "http://www.ardakaplan.com/ardroid/app_icons/";

        List<RDAGooglePlayApplication> list = new ArrayList<>();


        list.add(new RDAGooglePlayApplication(1,
                "Bebeğim",
                "My Baby",
                "com.ardakaplan.mybaby",
                -1,
                "Bebeklerinizi ekleyin; anılarını ve aşılarını takip edin. Anı kartı oluşturun ve paylaşın.",
                "Add you babies, theirs memories and injections. Create sharable cards.",
                iconRootFolder + "my_baby_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Virtual English Teacher",
                "Virtual English Teacher",
                "com.ardakaplan.virtualenglishteacher",
                -1,
                "İngilizce sınavlara hazırlanan için, offline çalışabilen ingilizce test uygulaması.",
                "İngilizce sınavlara hazırlanan için, offline çalışabilen ingilizce test uygulaması.",
                iconRootFolder + "icon_virtual_english_teacher.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Widget",
                "Text Widget Maker",
                "com.ardakaplan.virtualenglishteacher",
                -1,
                "Uygulama widget ını ekranınıza taşıyın. Uygulamaya girerek ne istiyorsanız yazın. Yazınız widget ta görüntülenecektir.",
                "Write whatever you want. And drag widget to your home or lock screen. Your text will be together with you.",
                iconRootFolder + "widget_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "TapTap",
                "TapTap",
                "com.rda.tabtab",
                -1,
                "Ekrana tıklayarak puan kazanabileceğiniz bir oyun.",
                "Simple and easy game . All you need to get the points, is taping the screen.",
                iconRootFolder + "taptap_icon.jpg"));

        list.add(new RDAGooglePlayApplication(2,
                "Cihaz Bilgisi",
                "Device Info",
                "com.rda.deviceInfo",
                -1,
                "Cihaza ait temel bilgileri gösterir.",
                "Shows basic info about your device. It also provides dp and sp size.",
                iconRootFolder + "device_info_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Not",
                "Note",
                "com.rda.note",
                -1,
                "Kendinize notlar yazın.",
                "Writing and editing note for yourself.",
                iconRootFolder + "note_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "İlişki Sayacı",
                "Relationship Time Counter",
                "com.ardroid.allaboutus",
                -1,
                "Ne kadar zamandır beraber olduğunuzu görün. Tarihleri girin ve geçen süreyi yıl, ay, gün, saat, dakika, saniye olarak görün. Kendinize özel bildirim üretin ve sürekli ekranda kalmasınız sağlayın.",
                "See how long you are together. Set your meeting, starting relationship, marriage day and than application calculates passing time for you. You can see how many years,months,days,hours,minutes.Or any date, you want. Just as you want.",
                iconRootFolder + "relationship_time_counter_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Döviz Kurları",
                "Döviz Kurları",
                "com.rda.dovizkurlari",
                -1,
                "Bankalara ve serbest piyasaya ait döviz bilgileri",
                "Bankalara ve serbest piyasaya ait döviz bilgileri",
                iconRootFolder + "doviz_kurlari_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Karar Ver",
                "Decide",
                "com.rda.dovizkurlari",
                -1,
                "Karar vermekte zorlanıyorsanız, bırakın cevapları DECIDE bulsun.",
                "Ask your question and application find a answer for you.",
                iconRootFolder + "decide_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "QR Kod Okuyucu",
                "QR Code Reader",
                "com.rda.qrcodereader",
                -1,
                "QR kodları okur ve içerdikleri bilgileri size gösterir.",
                "Scans the qr codes and shows the urls.",
                iconRootFolder + "qr_code_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Namaz Vakitleri",
                "Prayer Times",
                "com.ardroid.ezanvakitleri",
                -1,
                "Ülke, il, ilçe seçerek bulunduğunuz yerin namaz vakitlerini görün. İsterseniz vakitleri haftalık veya aylık olarak da görebilirsiniz.",
                "See prayer times buy choosing country - city - district. If you want, you can see monthly and weekly prayer times. All datas coming from http://www.diyanet.gov.tr/tr/namazvakitleri",
                iconRootFolder + "namaz_vakitleri_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Arda Kaplan",
                "Arda Kaplan",
                "com.rda.ardakaplan",
                -1,
                "Arda Kaplan kimdir ?",
                "Who is Arda Kaplan ?",
                iconRootFolder + "arda_kaplan_icon.png"));

        list.add(new RDAGooglePlayApplication(2,
                "Notify",
                "Notify",
                "notify_icon.png",
                -1,
                "Hatırlatma oluşturma aracı",
                "You can easily create notes for your own.",
                iconRootFolder + "arda_kaplan_icon.png"));

        return list;

    }
}
