# UAS (Pemrosesan Data Tersebar / CR01)

Membuat Aplikasi Pembelian dan Penjualan dengan menggunakan database Oracle, System Administrator menggunakan CodeIgniter dan Interface di Mobile Apps (Android). Komunikasi data antar Aplikasi menggunakan RESTful Service_  di oracle.

# Requirement

-   [Virtual Box](https://www.virtualbox.org/wiki/Downloads)  (Virtual Server)
-   [Oracle Developer Day 11g](https://www.oracle.com/technetwork/database/enterprise-edition/databaseappdev-vm-161299.html)  (Database)
-   [Android Studio](https://developer.android.com/studio)  (Android IDE)
-   [Codeigniter](https://www.codeigniter.com/)  (Framework PHP)

## Tutorial
Langkah - langkah dalam membuat Aplikasi Pembelian dan Penjualan dengan menggunakan database Oracle, Codelgniter dan Interface di Mobile Apps (Android).



## Database

Aplikasi Pembelian dan Penjualan terdapat sebuah 5 table, yaitu :
1. Customer
2. Barang
3. Penjualan
4. Pembelian
5. Supplier

## Table Barang 
![Table Barang!](./BARANG/table_barang.PNG "Table Barang")

## Barang 
![Table Barang!](./BARANG/barang.png "Table Barang")

## GET_Barang 
![Table Barang!](./BARANG/get_barang.png "Table Barang")

## POST_Barang 
![Table Barang!](./BARANG/post_barang.PNG "Table Barang")
![Table Barang!](./BARANG/post_barangb.PNG "Table Barang")

## PUT_Barang 
![Table Barang!](./BARANG/put_barang.PNG "Table Barang")
![Table Barang!](./BARANG/put_barangb.PNG "Table Barang")

## DELETE_Barang 
![Table Barang!](./BARANG/delete_barang.PNG "Table Barang")


## Table Customer
![Table Barang!](./BARANG/table_customer.png "Table Barang")

## Customer
![Table Barang!](./BARANG/customer.PNG "Table Barang")

## GET_Customer
![Table Barang!](./BARANG/get_customer.PNG "Table Barang")

## POST_Customer
![Table Barang!](./BARANG/post_customer.PNG "Table Barang")

## PUT_Customer
![Table Barang!](./BARANG/put_customer.PNG "Table Barang")
![Table Barang!](./BARANG/put_customerb.PNG "Table Barang")

## DELETE_Customer
![Table Barang!](./BARANG/delete_customer.PNG "Table Barang")



## Table Supplier
![Table Barang!](./BARANG/table_supplier.PNG "Table Barang")

## Supplier
![Table Barang!](./BARANG/supplier.png "Table Barang")

## GET_Supplier
![Table Barang!](./BARANG/get_supplier.PNG "Table Barang")

## POST_Supplier
![Table Barang!](./BARANG/post_supplier.PNG "Table Barang")

## PUT_Supplier
![Table Barang!](./BARANG/put_supplier.PNG "Table Barang")

## DELETE_Supplier
![Table Barang!](./BARANG/delete_supplier.PNG "Table Barang")



## Table Pembelian
![Table Barang!](./BARANG/table_pembelian.PNG "Table Barang")

## Pembelian
![Table Barang!](./BARANG/pembelian.png "Table Barang")

## GET_Pembelian
![Table Barang!](./BARANG/get_pembelian.PNG "Table Barang")

## POST_Pembelian
![Table Barang!](./BARANG/post_pembelian.PNG "Table Barang")
![Table Barang!](./BARANG/post_pembelianb.PNG "Table Barang")



## Table Penjualan
![Table Barang!](./BARANG/table_penjualan.PNG "Table Barang")

## Penjualan
![Table Barang!](./BARANG/penjualan.png "Table Barang")

## GET_Penjualan
![Table Barang!](./BARANG/get_penjualan.PNG "Table Barang")

## POST_Penjualan
![Table Barang!](./BARANG/post_penjualan.PNG "Table Barang")
![Table Barang!](./BARANG/post_penjualanb.PNG "Table Barang")



## Codelgniter
[Script](https://github.com/residwi/oracle-uas/blob/master/oracle-uas/application/libraries/Api.php) dibawah ini merupakan script php yang digunakan untuk mengakses _RESTful Services_ dari Oracle menggunakan library[Goutte](https://github.com/FriendsOfPHP/Goutte).

```php
use GuzzleHttp\Client;

defined('BASEPATH') or exit('No direct script access allowed');

class Api
{
    private $client;

    public function __construct()
    {
        // base url yang digunakan untuk mengakses RESTful API
        $this->client = new Client(['base_uri' => 'http://192.168.43.75:8888/apex/obe/']);
    }

    public function request($method, $uri, $data = [])
    {
        // data di convert menjadi data JSON
        $options['json'] = $data;

        // jika metode HTTP nya adalah DELETE maka response yang diberikan adalah status code nya
        if ($method == 'delete') {
            $request = $this->client->request($method, $uri);
            return $request->getStatusCode();
        }

        $request = $this->client->request($method, $uri, $options);

        // response yang diberikan berupa content nya
        return $request->getBody()->getContents();
    }
}
```