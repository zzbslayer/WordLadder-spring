# Wordladder springboot version

## 1. Programme Structure
- Spring boot
- Spring Security
- Spring Data JPA
- Mysql

## 2. Before running this app
Wordladder service will be available after authenticating as <b>ADMIN</b>.

Spring-Security will check from mysql.

Fix the application.properties to connect to the local database.

<b>There're two sql files under /sql/</b>

These files help you 
- create a database called wordladder.
- create tables called users and roles
- insert users data

Source these files in mysql.

<code>
mysql > source {path/table.sql}

mysql > source {path/data.sql}
</code>

There're two account.
- Username:zzbslayer password:password role:ADMIN
- Username:ddslayer password:password role:USER


## 3. Running Example

After all preparation done, visit\
<code>
localhost:8081
</code>

After authenticating as <b>ADMIN</b>, wordladder service will be available

The <b>ADMIN</b> account:
- Username:zzbslayer password:password role:ADMIN

<code>
localhost:8081/WordLadder/apple&keep

A ladder from keep back to apple: apple ample amole mole moe mee bee beep keep
</code>

If visiting wordladder without authencating, spring security will redirect you to the login page.