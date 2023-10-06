# Santander Spring Boot dio


## DIAGRAMA DE CLASSE
``` mermaid
classDiagram
class Usuario {
- name: String
- account: Conta
- features: Recurso[]
- card: Cartao
- news: Noticia[]
}
class Conta {
- number: String
- agency: String
- balance: Float
- limit: Float
}
class Recurso {
- icon: String
- description: String
}
class Cartao {
- number: String
- limit: Float
}
class Noticia {
- icon: String
- description: String
}

Usuario "1" *-- "1" Conta
Usuario "1" *-- "N" Recurso
Usuario "1" *-- "1" Cartao
Usuario "1" *-- "N" Noticia
```