package com.sahin.MobilOkul.Inheritance;

import java.util.ArrayList;
import java.util.Arrays;

public class Storys {
    public String birdsPage0="Ahmet'in Kuşları";
    public String birdsPage2="Ahmet’in en sevdiği şey kitapların resimlerinebakmaktı. Renkli renkli sayfalarıincelemekten çok keyif alırdı";
    public String birdsPage3="Bir gün babası ona kuşlarla ilgili bir kitap aldı. Ahmet kitabın sayfalarını hemen karıştırmaya başladı. Kitapta çok güzel resimleri kuş vardı";
    public String birdsPage4="Babası “Kitabına yarın da bakabilirsin, bugün hava çok güzel bahçeye çıkmak ister misin? diye sordu. Ahmet’in canı bahçeye çıkmak istemiyordu; “Hayır babacığım, odamda yeni kitabımı inceleyeceğim.” diye cevap verdi.";
    public String birdsPage5="Ahmet yatağına uzanıp kitabın sayfalarını tek tek çevirmeye başladı. Sayfalar kuş resimleriyle doluydu.";
    public String birdsPage6="Sayfaları çevirdikçe uykusu gelmeye başlamıştı ama kitabını elinden bırakamadı. Sonra yavaş yavaş gözleri kapandı.";
    public String birdsPage7="Gözlerini açtığında kendisini kocaman bir bahçede buldu. “Nasıl geldim ben buraya?” dedi kendi kendine…";
    public String birdsPage8="Önce biraz şaşırdı ama sonra bahçede gezmeye başladı. Çeşit çeşit kuşlar etrafında uçuşuyordu. Ahmet kuşları izlemeye başladı.";
    public String birdsPage9="Şu taklacı güvercinler, ne de güzel dönüyor.";
    public String birdsPage10="Kumrular da gu gugu gu diye ötüyor. Ahmet kumruları taklit etti  gu gugu gu...";
    public String birdsPage11="Sığırcıkların tüyleri güneşte parıl parıl parlıyor.";
    public String birdsPage12="Serçeler küçücük kanatlarını açmış uçuyor…";
    public String birdsPage13="Kırlangıçlar uçarken ne de güzel süzülüyor. Martıların sesleri ise uzaktan geliyor.";
    public String birdsPage14="Onları göremiyorum ama seslerini duyuyorum. Neredeler acaba?";
    public String birdsPage15="Ahmet martı sesleriyle birden uyandı. Kendisini yatağında bulunca şaşırdı.";
    public String birdsPage16="“Aaa! Bahçede değilmişim, hepsi rüyaymış.” dedi. “Babamla dışarıya çıksak kitaptaki kuşları görebilirim.”diye düşündü.";
    public String birdsPage17="Birlikte sahile indiler. Ahmet kuşları görünce sevinçle onlara el salladı.";
    public String birdsPage19="Martılar da Ahmet ile babasının etrafında uçmaya başladı. Güneş batarken martıların uçuşunu mutlulukla izlediler.";

    String [] storyBirdsArray ={birdsPage0,null,birdsPage2,birdsPage3,birdsPage4,birdsPage5,birdsPage6,
            birdsPage7,birdsPage8,birdsPage9,birdsPage10,birdsPage11,birdsPage12,birdsPage13,birdsPage14,birdsPage15,birdsPage16,birdsPage17
    ,null,birdsPage19};
    ArrayList<String> storyList=new ArrayList<>(Arrays.asList(storyBirdsArray));

    public void setBirdStoryList(ArrayList<String> storyList) {
        storyList.addAll(Arrays.asList(storyBirdsArray));
        this.storyList = storyList;
    }


    public String dreamPage0="Sevgi'nin Hayal Halkaları";
    public String dreamPage1="Dilek öğretmenin öğrencileri resim yapmayı çok severler. Her biri birbirinden güzel resimler yaparlar. ";
    public String dreamPage2="Dilek öğretmen her sanat etkinliğinden sonra yapılan resimleri toplar. Sınıfın dört bir yanına asar.";
    public String dreamPage4="Ömer en çok kedisi Gümüş’ün resmini çizmeyi sever.";
    public String dreamPage5="Tuba evlerinin bahçesindeki meyve ağaçlarını çizer.";
    public String dreamPage6="Merve parıl parıl parlayan yıldızları çizer.";
    public String dreamPage7="Erkan robot çizmeyi sever..";
    public String dreamPage8="Burcu masmavi denizlere açılmış kayık resimleri yapar.";
    public String dreamPage9="Sevgi ise renkli kocaman halkalar çizer. Halkaları çizmeyi o kadar çok sever ki bazen sayfalarca renkli çemberler çizer";
    public String dreamPage10="Çocuklar Sevgi’nin halkalarını çok severler. Bir araya gelip, halkaları başka bir şeylere benzetirler.";
    public String dreamPage11="Onları bazen simite. . .";
    public String dreamPage15="Bazen bisiklet tekerleğine...";
    public String dreamPage17="Bazen de dev hulahoplara benzetirler.";
    public String dreamPage18="Bu yüzden Dilek Öğretmen bu resimlere hayal halkaları der.";
    public String dreamPage19="Sevgi’nin hayal halkaları çocukların hayal dünyasını geliştirir.";
    public String dreamPage20="Hep birlikte farklı hayaller kurarlar.";

    String [] storyDreamArray ={dreamPage0,dreamPage1,dreamPage2,null,dreamPage4,dreamPage5,dreamPage6,
            dreamPage7,dreamPage8,dreamPage9,dreamPage10,dreamPage11,null,null,dreamPage15,null,dreamPage17
            ,dreamPage18,dreamPage19,dreamPage20};
    ArrayList<String> dreamStoryList=new ArrayList<>(Arrays.asList(storyBirdsArray));

    public void setDreamStoryList(ArrayList<String> dreamStoryList) {
        dreamStoryList.addAll(Arrays.asList(storyDreamArray));
        this.dreamStoryList = dreamStoryList;
    }

    public String forestPage0="Daireler Ormanın Kralı";
    public String forestPage1="Bilge, her sabah annesi ile birlikte anaokuluna gidiyor. Bilge’nin okulu evlerine çok yakın. Sabahları okula giderken araç yolu çok gürültülü oluyor.";
    public String forestPage2="Her yerde sürücüler korna çalıyor. Annesi Bilge’yi, “Sakin ol Bilge, ben buradayım!” diyerek sakinleştiriyor. “Sussun! Sussun araba!” diyor Bilge, korna sesinden hiç hoşlanmıyor.";
    public String forestPage3="Bilge her gün aynı yoldan geçmeyi seviyor. Parkın olduğu yolda meşe ağaçları var. Bilge, ağaçlara bakmaktan hoşlanıyor.";
    public String forestPage4="Parkta pek çok kırlangıç var. Sabahları kimse yokken tahterevalliye kırlangıçlar konuyor. Bilge, kırlangıçları saymayı çok seviyor. 1 kırlangıç, 2 kırlangıç, 3 kırlangıç. Bugün 3 kırlangıç var.";
    public String forestPage5="Bilge okula gelince her zamanki sandalyesine oturuyor. Zeynep öğretmen ona yaklaşarak, “Hoş geldin, nasılsın Bilge?” diyor. Bilge, “İyiyim öğretmenim.” diye cevap veriyor. Bilge, öğretmenini çok seviyor.";
    public String forestPage6="Anaokulunda pek çok güzel resim yapıyor. Ayrıca şarkı söylüyor, dans ediyor ve deney yapıyor...";
    public String forestPage7="Zeynep Öğretmen sınıftakilere sesleniyor: “Haydi oyun zamanı!” Sonra Bilge’ye dönüp, “Bilge, sen nerede, hangi oyuncakla oynamak istersin?” diye ekliyor. Bilge, “Blok merkezi. Dairelerle oynayacağım. Daire döndüreceğim. Araba süreceğim.” diyor.";
    public String forestPage8="Bilge, blok merkezine geçiyor ve daireleri eline alıyor. Yanına arkadaşı Özüm geliyor. Özüm, “Bilge, beraber araba sürelim mi? Trafik oyunu oynayalım.” diyor. ‘‘Sürelim.’’ diyor Bilge.";
    public String forestPage9="Beraber oynamaya başlıyorlar. Sonra yanlarına Murat ve Yeşim de geliyor. Bir arada trafik oyunu oynuyorlar.";
    public String forestPage10="Daha sonra öğretmen, “Şimdi şarkımızı söyleyelim. Hep beraber dans edelim.” diyor. Tüm çocuklar müzik eşliğinde dans ediyorlar.";
    public String forestPage11="Öğretmen, dans etmekten yorulan çocuklara hayvanlarla ilgili bir kitap okuyor. Kitap bitince de, “Çocuklar! Haydi bu kitapta geçen hikâyeyi canlandıralım.” diyor.";
    public String forestPage12="Öğretmen hikâyeyi canlandırmaya başlarken Bilge’nin bloklarla oynamaya devam ettiğini görüyor.";
    public String forestPage13="Öğretmen: “Bilge, düşün bakalım. Ormanda hangi hayvanı canlandırmak istersin?” Bilge: “Ben daire ile oynayacağım.” Öğretmen: “Şöyle yapalım. Burası daireler ormanı olsun. Sen de bu ormanda yaşayan bir canlı ol!” Bilge gülümsüyor ve ”Tamam!” diyor.";
    public String forestPage14="Çocuklar hayvan maskelerini takıyor ve hikâyeyi canlandırmaya başlıyorlar. Bilge ise hangi maskeyi takacağını düşünüyor.";
    public String forestPage15="Özüm, elinde bir kral tacı ile Bilge’nin yanına geliyor. “Bilge istersen bunu tak. Sen de Daireler Ormanı’nın Kralı ol.” diyor.";
    public String forestPage16="Bilge seviniyor ve hemen tacı takıyor. Arkadaşları ile birlikte Daireler Ormanı’nda el ele tutuşuyorlar ve birlikte oynuyorlar.";
    public String forestPage17="Öğretmen çocuklara, “Daireler Ormanı nasıl bir yer olabilir? Oranın resmini yapabilir misiniz?” diyor. Tüm çocuklar hayalindeki Daireler Ormanı’nı çiziyor ve boyuyor.";
    public String forestPage18="Öğlen olunca, babası Bilge’yi okuldan almaya geliyor. Sınıf panosuna bakarken, tam ortada kral tacı takmış bir çocuğun fotoğrafını görüyor.";
    public String forestPage19="Ertesi sabah Bilge, annesi ile birlikte aynı yoldan okula yürüyor. Parka yaklaşınca tahterevallinin üzerinde kaç tane kırlangıç var sayıyor. “Bir kırlangıç, iki kırlangıç, üç kırlangıç, dört kırlangıç.” “Bugün dört kırlangıç var.” diyor Bilge.";

    String [] storyForestArray ={forestPage0,forestPage1,forestPage2,forestPage3,forestPage4,forestPage5,forestPage6,
            forestPage7,forestPage8,forestPage9,forestPage10,forestPage11,forestPage12,forestPage13,forestPage14,forestPage15,forestPage16,forestPage17
            ,forestPage18,forestPage19};
    ArrayList<String> forestStoryList =new ArrayList<>(Arrays.asList(storyBirdsArray));

    public void setForestStoryList(ArrayList<String> forestStoryList) {
        forestStoryList.addAll(Arrays.asList(storyForestArray));
        this.forestStoryList = forestStoryList;
    }


    public String friendPage0="Elma İle Gelen Arkadaşlık";
    public String friendPage1="Merhaba ben Çağıl. Anneannemin yaşadığı şehre yeni taşındık. Artık yeni bir okula gideceğim.";
    public String friendPage2="Bu şehri çok seviyorum. Burada çok güzel bir oyun parkı ve birçok meyve ağacı var. Ben meyve bahçesinde oyun oynamaya bayılırım. YAŞASIN!";
    public String friendPage3="Bugün anneanneme yemeğe geldik. “Hoşgeldin Çağıl. Artık daha çok birlikte olacağız.” dedi. “Ama burada hiç arkadaşım yok anneanne!” dedim. O da bana, “Üzülme Çağıl. Burada da birçok arkadaşın olur.” dedi.";
    public String friendPage4="Yemekten hemen sonra bahçeye çıktık. Anneannem ile top oynadık. Çok gol attım. “Gol! Gol!”";
    public String friendPage5="Ama anneannem biraz yorulmuştu. “Çağıl, ben çok yoruldum. Biraz dinleneyim. Sen oyna burada.” dedi. “Tamam anneanneciğim!” dedim.";
    public String friendPage6="Bahçede kocaman bir elma ağacı vardı. Ağaçtaki elmalar çok güzel görünüyordu. Yerden bir sopa alıp elmalardan birini düşürmeyi denedim. Off! Bir türlü olmuyordu. Ağaca çıkmaya karar verdim.";
    public String friendPage7="En alçak dala sıkıca tutunup ağaca tırmandım. Elmalara yaklaşmıştım ama uzanamıyordum. Aşağı bakınca çok korktum. Aşağı da inemiyordum. Ağaçta kaldım.";
    public String friendPage8="“Anne! Baba! Anneanne! Yardım edin!” diye seslendim. Biraz bekledikten sonra birinin bana seslendiğini duydum. “Ağaçta mı kaldın? Korkma ben hemen annemi çağıracağım.” dedi ve gitti.";
    public String friendPage9="Annesi geldi ve “Merhaba ben Aynur. Şimdi seni tutacağım ve aşağı indireceğim.” dedi. Sonra elini tutmamı istedi ve belimden tutup beni ağaçtan indirdi.";
    public String friendPage10="“Çok teşekkür ederim Aynur Teyze.” “Rica ederim. Bak, bu oğlum Yağız. Bana Yağız haber verdi.” “Teşekkürler Yağız!”";
    public String friendPage11="O sırada anneannem ve annem de geldi. “Demek komşularımızla tanıştın Çağıl.” “Evet anneanne. Aynur Teyze ve Yağız beni ağaçtan kurtardı.” Annem, “Ağaca tırmanırken biraz dikkatli olmalısın.” dedi. Annem haklıydı.";
    public String friendPage12="Annem, Aynur Teyze’ye ve Yağız’a teşekkür ederek, onları eve davet etti. Annemin yaptığı keki komşularımızla birlikte yedik. Sonra arkadaşım Yağız ile birlikte oyuncaklarımla oynadık.";
    public String friendPage13="Bu şehirdeki ilk günümde yeni bir arkadaşım oldu bile. Yağız, çevresini dikkatle dinliyor ve her şeyi aklında tutuyor. Bahçedeki ağaçların türlerini ve yerlerini ezbere söylüyor. Evleri ile okul arasındaki yolu çok iyi biliyor.";
    public String friendPage14="Yağız ile aynı sınıftayız. Öğretmenimiz Yağız’a sınıfı ve okulu elinden tutup dolaştırarak öğretmiş. Tüm eşyaların sabit bir yeri var. Böylece Yağız, sınıfı çabucak ezberlemiş. Hiçbir şeyi unutmuyor. Eşyaların yerlerini değiştirirken, Yağız’a haber vermemiz onun işini kolaylaştırıyor.";
    public String friendPage15="Yağız sesler konusunda uzman. Duyduğu her sesin neyin sesi olduğunu hemen anlıyor. Onunla birlikte okula gitmek çok eğlenceli.";
    public String friendPage16="Yolda yürürken duyduğumuz seslerin nereden geldiğini tahmin etme oyunu oynuyoruz. Öten kuşun hangi ağaçta ve büyük bir kamyonun ne kadar uzakta olduğunu sesini dinleyerek anlamaya çalışıyoruz.";
    public String friendPage17="Yağız ile okuldan sonra da bahçede oyun oynuyoruz. Beraber şarkı söylüyoruz. Anneannem bize kitap okuyor, masal anlatıyor.";
    public String friendPage18="İşte anneannem yine seslendi. “Çağıııl! Yağız geldi.” Hemen onun yanına koştum. “Yaşasınnn! Yağız, hoş geldin. Anneannem bize hangi masalı anlatacak çok merak ediyorum.” dedim. Yağız da bana, “Ben de çok merak ediyorum.” dedi.";
    public String friendPage19="Anneannem masala başlamadan “Evet! Bugünkü masalın adı Elma İle Gelen Arkadaşlık.” dedi.";

    String [] storyFriendArray ={friendPage0,friendPage1,friendPage2,friendPage3,friendPage4,friendPage5,friendPage6,
            friendPage7,friendPage8,friendPage9,friendPage10,friendPage11,friendPage12,friendPage13,friendPage14,friendPage15,friendPage16,friendPage17
            ,friendPage18,friendPage19};
    ArrayList<String> friendStoryList =new ArrayList<>(Arrays.asList(storyBirdsArray));

    public void setFriendStoryList(ArrayList<String> friendStoryList) {
        friendStoryList.addAll(Arrays.asList(storyFriendArray));
        this.friendStoryList = friendStoryList;
    }




}
