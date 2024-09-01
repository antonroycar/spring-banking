# Spring Banking

Spring Banking adalah aplikasi perbankan sederhana yang dikembangkan menggunakan Spring Framework. Aplikasi ini menyediakan API RESTful untuk mengelola akun bank, termasuk operasi seperti membuat akun, melihat detail akun, menyetor, menarik, dan menghapus akun.

## Fitur

- **Tambah Akun**: Menambahkan akun baru ke sistem.
- **Lihat Akun**: Mendapatkan detail akun berdasarkan ID.
- **Setor**: Menyetor uang ke akun berdasarkan ID.
- **Tarik**: Menarik uang dari akun berdasarkan ID.
- **Lihat Semua Akun**: Mendapatkan daftar semua akun.
- **Hapus Akun**: Menghapus akun dari sistem.

### AccountController.java

`AccountController` adalah kelas yang bertanggung jawab untuk menangani permintaan HTTP terkait akun. Kelas ini memiliki beberapa endpoint yang menyediakan fungsionalitas CRUD (Create, Read, Update, Delete) untuk akun bank.

- **POST /api/accounts**: Menambahkan akun baru.
- **GET /api/accounts/{id}**: Mendapatkan detail akun berdasarkan ID.
- **PUT /api/accounts/{id}/deposit**: Menyetor sejumlah uang ke akun.
- **PUT /api/accounts/{id}/withdraw**: Menarik sejumlah uang dari akun.
- **GET /api/accounts**: Mendapatkan semua akun yang tersedia.
- **DELETE /api/accounts/{id}**: Menghapus akun berdasarkan ID.

### AccountDto.java

`AccountDto` adalah kelas Data Transfer Object yang digunakan untuk mengirim data antara klien dan server. Kelas ini merepresentasikan data akun.

### AccountService.java

`AccountService` adalah kelas layanan yang mengelola logika bisnis terkait akun. Kelas ini dipanggil oleh `AccountController` untuk melakukan operasi pada data akun.

## Cara Menggunakan

### Prasyarat

- Java 11 atau lebih baru
- Maven

### Langkah-langkah

1. Clone repositori ini:
   ```bash
   git clone https://github.com/username/spring-banking.git
   ```
   
2. Buka proyek di IDE pilihan Anda.
  
3. Jalankan aplikasi:
   ```bash
   mvn spring-boot:run
   ```
   
4. Akses API menggunakan Postman atau aplikasi klien API lainnya.

## Contoh Permintaan API
### Tambah Akun  
  ```bash
    POST /api/accounts
    Content-Type: application/json
    
    {
    "accountName": "John Doe",
    "balance": 1000.0
    }
  ```
    
### Setor Uang
  ```bash
    PUT /api/accounts/1/deposit
    Content-Type: application/json

    {
    "amount": 500.0
    }
  ```
    
### Tarik Uang
  ```bash
    PUT /api/accounts/1/withdraw
    Content-Type: application/json

    {
    "amount": 200.0
    }
  ```

### Lihat Semua Akun
  ```bash
     GET /api/accounts
  ```
     
### Hapus Akun
  ```bash
     DELETE /api/accounts/1
  ```
