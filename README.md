![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/669fe975-6cea-4bbe-9e93-ff1426d9724a)![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/f21090e6-5909-4b4a-bc54-a2285a5d0aca)Enka Network adalah aplikasi antarmuka pengguna berbasis grafis (GUI) yang didedikasikan untuk mengelola dengan efisien daftar karakter yang diinginkan yang berasal dari game populer Genshin Impact. Aplikasi ini memberdayakan pengguna untuk mengekspresikan preferensi mereka dengan menambahkan karakter dari game-game tersebut dan melakukan “gacha” yang dimana pengguna dapat mendapatkan karakter secara acak.

Dalam pengembangan Aplikasi GUI Enka Network, kami mengambil referensi dari beberapa sumber untuk memperoleh pemahaman mendalam tentang JavaFX, kerangka pengembangan antarmuka pengguna berbasis Java yang digunakan dalam pembuatan aplikasi kami. Berikut adalah sumber referensi utama yang membantu kami selama proses pengembangan:

JavaTpoint - JavaFX Tutorial

Link: https://www.javatpoint.com/javafx-tutorial

Sumber ini memberikan tutorial terperinci tentang pengembangan aplikasi JavaFX. Kami merujuk ke sini untuk memahami dasar-dasar JavaFX, komponen-komponen yang tersedia, dan cara mengimplementasikannya dalam pembuatan antarmuka pengguna.
Introduction to JavaFX by NTU (Nanyang Technological University)

Link: https://www3.ntu.edu.sg/home/ehchua/programming/java/Javafx1_intro.html

Materi ini dari NTU memberikan pengantar menyeluruh tentang JavaFX, mencakup konsep dasar hingga penggunaan praktis dalam pengembangan aplikasi berbasis Java. Referensi ini menjadi landasan untuk pemahaman kami tentang konsep dan implementasi JavaFX.

Referensi ini membantu kami mengatasi tantangan utama dalam pengembangan Aplikasi GUI Enka Network. Pemahaman yang mendalam tentang komponen-komponen JavaFX dan layout menjadi kunci untuk membangun antarmuka pengguna yang efisien dan responsif. Dengan merujuk pada sumber-sumber ini, kami dapat mengoptimalkan pengembangan aplikasi kami sesuai dengan praktik terbaik yang telah mapan dalam pengembangan JavaFX.

Metodologi pengembangan Aplikasi GUI Enka Network melibatkan serangkaian langkah-langkah sistematis untuk memastikan pencapaian tujuan proyek secara efektif dan efisien. Berikut adalah metodologi yang kami terapkan:

1.	Perencanaan dan Analisis Kebutuhan:

1.1 Definisi Aplikasi:
Identifikasi kebutuhan dan fitur utama Enka Network, termasuk manajemen wishlist karakter, Character Lore dan fitur Owned Character. Dalam melakukan gacha, pengguna dapat melihat character yang ia dapatkan dan disimpan dalam database.

1.2 Penentuan Tujuan Aplikasi:
Tujuan dari aplikasi ini adalah untuk membantu pengguna dalam meluangkan waktu ketika dia sedang ingin bermain minigame gacha untuk memberikan kesenangan pada dirinya.

2.	Perancangan Aplikasi:

2.1	Unsur- Unsur Object Oriented :
Dalam mengembangkan aplikasi, kita menggunakan beberapa class diantaranya berupa class models dan class Main. Dimana untuk class models digunakan untuk menampung variable variable character dan pengguna. Dan class models tersebut akan dipanggil ke dalam class main.

2.2 Identifikasi Komponen:
Menentukan komponen-komponen yang dibutuhkan, seperti text box, tombol, tabel, dan lainnya.

2.3 Perencanaan Layout:
Untuk Layout aplikasi itu sendiri, yaitu ketika pengguna membuka aplikasi, sistem akan menampilkan halaman home yang terdapat judul aplikasi dibagian atas, button  menu character lore dibagian tengah, dan button menu owned character dibagian bawah. Jika pengguna menekan salah satu tombol dari fitur yang ada, maka halaman akan berganti scene ke halaman fitur tersebut

3.	Pembangunan Aplikasi:
3.1 Database yang digunakan :
Dalam Pembangunan aplikasi kami melakukan konektivitas database menggunakan MySQL phpMyAdmin ke dalam JavaFX. Hal ini dilakukan agar sistem dapat menyimpan data character yang pengguna dapatkan ketika dia sudah melakukan gacha. Dan juga digunakan untuk menyimpan data character yang terdapat didalam sistem.

1.	Landing PageHome Aplikasi
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/e071b48e-f62d-4b2b-86b1-8fbd0f6fafd0)

Pada bagian landing page, sistem akan menampilkan logo aplikasi dan untuk meneruskan ke halam main menu, pengguna perlu untuk menekan tombol enter untuk memasuki aplikasi 

2.	Menu Home Aplikasi
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/dcc74b92-9e5d-45c0-9258-d3fb8af9739f)

Pada bagian home aplikasi terdapat layout judul aplikasi dibagian atas, tombol menu character lore dibagian pertama, tombol menu gacha dibagian tengah, dan tombol menu Owned Character dibagian bawah.

Terdapat tombol toggle pada samping kanan tas menu, tombol tersebut berguna untuk menonaktifkan theme musik pada menu apabila pengguna ingin mematikannya.

3.	Menu Character Lore
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/e05a433c-07c6-4031-8156-a637901e7b54)
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/54dfb225-c796-4b67-ae87-dcf3ee37b993)

Pada bagian menu Character Lore,  terdapat table yang menunjukan karakter game yang terdapat didalam sistem, dan jika pengguna memilih salah satu data yang terdapat dalam table tersebut, sistem akan menampilkan informasi mengenai character tersebut.
Dalam menu ini, pengguna dapat melihat character apa saja yang dapat mereka dapatkan dan juga dapat melihat cerita dari karakter tersebut. 

4.	Menu Gacha
Pada bagian menu gacha, terdapat tombol gacha  yang ketika akan ditekan pengguna, sistem akan menampilkan character yang pengguna dapatkan secara acak dan setiap character memiliki value yang berbeda.. Lalu sistem akan menyimpannya kedalam database.
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/a0979bea-23db-4db6-9a06-b910b7bd61b0)

![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/f678b9f1-aa7f-49ec-8baa-e424c798dbcf)

![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/00d48bc5-c6f9-460b-8021-17d271d26dfc)


Pengguna juga dapat melihat berapa banyak roll mereka miliki dan dapat melihat berapa banyak jumlah maksimum rolls yang dapat dilakukan pengguna.

5.	Menu Owned Character
Pada bagian menu Owned Character, terdapat table yang menunjukan character yang telah didapatkan oleh pengguna. Pengguna juga dapat menjual character tersebut jika ingin sesuai dengan value karakter yang mereka dapatkan.
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/d84f00b6-b9a5-4995-a672-8a7e113f0eba)

![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/4d37adbe-5c61-4ba9-ad71-422643bf712a)

6.	Menu Shop
Penjual yang telah menjual karakter mereka akan mendapatkan diamond value, diamond value yang digunakan pengguna dapat digunakan untuk membeli perk yang ada dalam aplikasi. Perk yang ada dalam aplikasi dapat memberikan keutungan kepada pengguna dimana pengguna dapat menaikan maximum rolls yang dapat dimiliki oleh pengguna.
Lalu apabila pengguna ingin membeli perk tersebut, sistem akan menampilkan pop up yang berisikan harga perk yang diambil dan pengguna harus melakukan konfirmasi untuk mengkonfirmasi penggunaan diamond.
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/184137fd-f3e9-4e85-99fa-c34acf336d15)
![image](https://github.com/putukrisnanda/Enka.Network-Gacha-Feature-Application/assets/114864739/3d1c006c-949c-4e96-b61d-9b9a5e7d1255)


Tambahan Fitur yang akan datang
Tambahan perk yang dapat mengutungkan pengguna seperti mengurangi durasi waktu gacha yang dilakukan oleh pengguna dan juga tambahan karakter yang lebih banyak pada aplikasi sehingga membuat pengguna dapat memiliki banyak karakter yang mereka suka. Selain itu, untuk menambhakan tantangan baru pada aplikasi. Akan terdapat fitur pengadaan senjata sehingga membuat pengguna lebih sulit untuk mendapatkan karakter yang mereka inginkan.
	Selain itu, fitur online juga akan ditambahkan untuk membuat minigame menjadi menarik. Untuk membuat fitur online akan terdapat beberapa fitur yang dapat ditambahkan seperti pembuatan login untuk mendapatkan userID, Trade yang dapat digunakan untuk bertukar karakter yang dimiliki oleh pemain lain dan juga fitur friend dimana pengguna dengan temannya akan terhubung kedalam database dan memiliki 1 database yang sama. Sehingga 1 orang hanya dapat memiliki 1 karakter dari database yang membuat trade diperlukan.
