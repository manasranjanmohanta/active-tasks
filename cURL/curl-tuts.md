# What is CURL?

- cURL, which stands for client URL, is **a command line tool that developers use to transfer data to and from a server**. At the most fundamental, cURL lets you talk to a server by specifying the location (in the form of a URL) and the data you want to send.
- cURL supports several different [protocols](https://curl.se/docs/url-syntax.html), including HTTP and HTTPS, and runs on almost every platform. This makes cURL ideal for testing communication from almost any device (as long as it has a command line and network connectivity) from a local server to most [edge devices](https://www.ibm.com/cloud/architecture/architectures/edge-computing?utm_source=ibm_developer&utm_content=in_content_link&utm_id=articles_what-is-curl-command&cm_sp=ibmdev-_-developer-articles-_-ibmcom).
- cURL, pronounced "curl", is ==a free, open-source command-line tool and library that allows users to exchange data between their device and a server using a variety of network protocols==.


- Curl is a command-line tool and library for transferring data with URLs. It supports a wide range of protocols, including HTTP, HTTPS, FTP, FTPS, LDAP, SCP, SFTP, TFTP, TELNET, DICT, FILE, and more. Curl is highly flexible and can be used to perform various operations such as downloading and uploading files, sending requests to web servers, testing APIs, and much more.

## Why use curl?

- It is highly portable. It is compatible with almost every operating system and connected device.
- It is useful for testing endpoints, to check if they are working.
- It can be verbose, providing details of exactly what has been sent/received, which is helpful for debugging.
- It has good error logging.
- It can be rate limited.

## Sending API requests
Curl is used to send API requests. Each request is generally made up of four main parts:

- An **endpoint**, which is the address (URL) to which we are sending the request.
- An **HTTP method**. The most common methods used are GET, POST, PUT and DELETE.
    
    - **GET** is used to retrieve a resource from a server. This could be a file, information, or an image.
    - **POST** is used to send information to the server.
    - **PUT** can be used to create or update a resource. This could be used to create or update a record in a database or update the contents of a file.
    - **DELETE** is used to delete a resource such as a database entry.
- **Headers**, which contain metadata about the request, such as content type, user agent, and so on.
 - **Body**, which is the message body and contains the data that we want to send, if any. Generally, the body is used with POST and PUT methods.

1. **Customizing Requests**:
    
    - `-X, --request <command>`: Specifies the HTTP request method (GET, POST, PUT, DELETE, etc.).
    - `-d, --data <data>`: Sends data in a POST request. You can use this option to send form data or JSON payloads.
    - `--data-raw <data>`: Sends data without any processing (useful for sending binary data).
    - `-F, --form <name=content>`: Sends data as a multipart form.
    - `-H, --header <header>`: Adds custom headers to the request.
2. **Handling Cookies**:
    
    - `-b, --cookie <name=value>`: Sends cookies from a file or string.
    - `-c, --cookie-jar <file>`: Stores cookies in a file.
    - `-j, --junk-session-cookies`: Ignores session cookies.
3. **Setting Headers**:
    
    - `-H, --header <header>`: Adds custom headers to the request.
    - `-A, --user-agent <agent>`: Sets the User-Agent header.
    - `-e, --referer <URL>`: Sets the Referer header.
4. **Advanced Tasks**:
    
    - `-k, --insecure`: Allows insecure SSL connections.
    - `--compressed`: Requests compressed response data.
    - `--limit-rate <speed>`: Limits the transfer speed.
    - `--max-time <seconds>`: Sets the maximum time for the request.
    - `-v, --verbose`: Displays detailed information about the request and response.

For example, if you wanted to send a POST request with JSON data and a custom header using Curl, you could use a command like this:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"key": "value"}' https://api.example.com/endpoint

```

Here are examples of using each command with Curl:


1. **Customizing Requests**:
`-X, --request <command>`: Specifies the HTTP request method (GET, POST, PUT, DELETE, etc.).
```bash
curl -X GET https://api.example.com/resource
```

- `-d, --data <data>`: Sends data in a POST request. You can use this option to send form data or JSON payloads.
```bash
curl -X POST -d "username=user&password=pass" https://api.example.com/login
```

- `--data-raw <data>`: Sends data without any processing (useful for sending binary data).
```bash
curl -X POST --data-raw @file.bin https://api.example.com/upload
```

- `-F, --form <name=content>`: Sends data as a multipart form.
```bash
curl -X POST -F "file=@/path/to/file.txt" https://api.example.com/upload
```

- `-H, --header <header>`: Adds custom headers to the request.
```bash
curl -H "Authorization: Bearer token" https://api.example.com/resource
```


2. **Handling Cookies**:
- `-b, --cookie <name=value>`: Sends cookies from a file or string.
```bash
curl -b "session_id=abc123" https://api.example.com/resource
```

- `-c, --cookie-jar <file>`: Stores cookies in a file.
```bash
curl -c cookies.txt https://api.example.com/login
```

- `-j, --junk-session-cookies`: Ignores session cookies.
```bash
curl -j https://api.example.com/resource
```


3. **Setting Headers**:
- `-H, --header <header>`: Adds custom headers to the request.
```bash
curl -H "Content-Type: application/json" https://api.example.com/resource
```

- `-A, --user-agent <agent>`: Sets the User-Agent header.
```bash
curl -A "Mozilla/5.0" https://api.example.com/resource
```

- `-e, --referer <URL>`: Sets the Referer header.
```bash
curl -e "https://www.referer.com" https://api.example.com/resource
```


4. **Advanced Tasks**:
- `-k, --insecure`: Allows insecure SSL connections.
```bash
curl -k https://insecure.example.com/resource
```

- `--compressed`: Requests compressed response data.
```bash
curl --compressed https://api.example.com/compressed
```

- `--limit-rate <speed>`: Limits the transfer speed.
```bash
curl --limit-rate 100K https://api.example.com/resource
```

- `--max-time <seconds>`: Sets the maximum time for the request.
```bash
curl --max-time 10 https://api.example.com/resource
```

- `-v, --verbose`: Displays detailed information about the request and response.
```bash
curl -v https://api.example.com/resource
```

#### Notes:
You can write a cURL command in multiple lines by using a backslash `\` at the end of each line except for the last line. Here's an example of how you can format your cURL command across multiple lines:
```bash
curl -X POST "http://localhost:3306/api/v1/employees" \
--header "Content-Type: application/json" \
--data '{
  "name": "Manas",
  "age": 23,
  "salary": 20000,
  "address": "BBSR"
}'
```
In this example:

- The backslash `\` at the end of each line (except the last one) indicates that the command continues on the next line.
- The JSON data is formatted across multiple lines for better readability, but it's still part of the same `--data` argument.
- In summary, `-X` in cURL allows you to specify the HTTP request method to be used when interacting with a server.

