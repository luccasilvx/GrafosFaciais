# 📘 README - Projeto Backend: Reconhecimento Facial com Eigenfaces + Teoria dos Grafos

## 📌 Sobre o Projeto
Este projeto consiste em uma aplicação **exclusivamente backend**, desenvolvida com **Java + Spring Boot**, cujo objetivo é realizar a **comparação de rostos** utilizando a técnica de **Eigenfaces (redução de dimensionalidade com PCA)** e modelagem da similaridade facial com **teoria dos grafos**. A aplicação expõe um endpoint REST que recebe duas imagens e retorna a **probabilidade de serem da mesma pessoa**.

## 🎯 Objetivo
A ideia é explorar algoritmos de álgebra linear e redes (grafos) para construir uma base de reconhecimento facial de forma rápida, leve e gratuita, com foco em:
- Eficiência na comparação de rostos
- Redução de dimensionalidade com Eigenfaces
- Estruturação e visualização com Teoria dos Grafos

## 🛠️ Tecnologias Utilizadas

| Tecnologia         | Finalidade                                  |
|--------------------|----------------------------------------------|
| Java 17+           | Linguagem principal                         |
| Spring Boot        | Framework backend REST                     |
| Apache Commons Math| Suporte a operações matemáticas (PCA)      |
| JGraphT            | Modelagem e manipulação de grafos          |
| OpenCV (opcional)  | Processamento de imagem (via integração JNI)|
| Postman            | Teste de endpoints Multipart (upload)      |

## 🔧 Como instalar e executar

1. Clone este repositório:
```bash
git clone https://github.com/seu-usuario/nome-do-projeto.git
```

2. Importe como projeto Maven no IntelliJ, Eclipse ou outro IDE.

3. Configure `application.properties`:
```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

4. Instale as dependências Maven:
```bash
mvn clean install
```

5. Execute a aplicação:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em:
```
http://localhost:8080
```

## 📤 Como utilizar

### Endpoint: `/faces/compare`

- **Método**: `POST`
- **Content-Type**: `multipart/form-data`
- **Parâmetros**:
  - `img1`: imagem da primeira pessoa (campo do tipo arquivo)
  - `img2`: imagem da segunda pessoa (campo do tipo arquivo)

### Exemplo via Postman:
1. Selecione método `POST`
2. URL: `http://localhost:8080/faces/compare`
3. Aba `Body > form-data`
4. Campos:
   - `img1`: tipo `File`, selecione a imagem 1
   - `img2`: tipo `File`, selecione a imagem 2

### Retorno esperado:
```json
{
  "similarity_percentage": "88.23%",
  "raw_score": 0.8823
}
```

## 🧠 Lógica do Projeto

1. **Conversão de Imagem para Vetor**:
   - Cada pixel é transformado em um valor numérico (tons de cinza)
   - Gera-se um vetor de alta dimensionalidade

2. **Redução com PCA (Eigenfaces)**:
   - Mantém apenas os componentes principais (100 primeiras dimensões)
   - Reduz o custo computacional mantendo identidade facial

3. **Comparação Vetorial**:
   - Calcula a **similaridade cosseno** entre os vetores reduzidos
   - Retorna o score entre `0` e `1`

4. **Grafo de Similaridade Facial (Futuro)**:
   - Cada vértice representa uma face conhecida
   - Arestas representam similaridade entre vetores faciais

## 🧱 Arquitetura REST Simplificada

```
┌──────────────┐
│  Controller  │  → Recebe as imagens (img1, img2)
└────┬─────────┘
     ↓
┌──────────────┐
│   Service    │  → Coordena o fluxo: vetorização, PCA, comparação
└────┬─────────┘
     ↓
┌──────────────┐      ┌──────────────┐
│ ImageUtil    │      │ PCAUtil      │
│ (vetores)    │      │ (redução)    │
└──────────────┘      └──────────────┘
     ↓
┌──────────────┐
│ Similarity   │  → Similaridade cosseno entre vetores
└──────────────┘
```

## 📈 Possíveis Extensões Futuras
- Implementar PCA real com matriz de covariância
- Armazenar faces conhecidas e montar grafo com `JGraphT`
- Aplicar algoritmos de centralidade para detectar rostos mais representativos
- Criar endpoint para cadastrar e comparar com base de faces
- Implementar autenticação JWT para segurança da API

## ✍️ Autor
Lucas Freitas da Silva  
RA: 41358  
Desenvolvedor Java | Eng. da Computação

---
Este projeto demonstra a junção de técnicas matemáticas com estrutura de grafos para resolver um problema real de forma modular, inteligente e extensível.
