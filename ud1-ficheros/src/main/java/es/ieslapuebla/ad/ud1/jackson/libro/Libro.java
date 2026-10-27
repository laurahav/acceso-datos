package es.ieslapuebla.ad.ud1.jackson.libro;


import com.fasterxml.jackson.annotation.*;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

// No se escriben en JSON las propiedades cuyo valor sea null
@JsonInclude(JsonInclude.Include.NON_NULL)
// Fija el orden de las claves cuando se serializa (solo estética/legibilidad)
@JsonPropertyOrder({ "titulo", "autor", "publicado_en" })
// Convierte automáticamente los nombres Java (por ejemplo, publicadoEn) a
// snake_case en JSON (publicado_en), salvo que lo sobrescribas con @JsonProperty
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
// Define el nombre de la raíz si activas en el ObjectMapper
// WRAP_ROOT_VALUE/UNWRAP_ROOT_VALUE (salida: { "Libro": { ... } })
@JsonRootName("Libro")
public class Libro {
    // La clave en JSON será exactamente "titulo" (aunque la estrategia ya la
    // dejaría igual; aquí lo fijamos explícitamente)
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("autor")
    private String autor;
    // Campo excluido del JSON (ni se escribe ni se lee)
    @JsonIgnore
    private String internalId;
    // Sin anotación: la estrategia SnakeCase lo convierte a "publicado_en"
    private int publicadoEn;

    // Constructor vacío recomendado: facilita la deserialización basada en
    // setters/campos
    public Libro() {
    }

    // Jackson usará este constructor al deserializar.
    // Cada @JsonProperty("...") vincula el parámetro con la clave del JSON.
    // Nota: aquí especificamos "publicado_en" para que case con la estrategia snake_case.
    @JsonCreator
    public Libro(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("autor") String autor,
            @JsonProperty("publicado_en") int publicadoEn
    ) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicadoEn = publicadoEn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPublicadoEn() {
        return this.publicadoEn;
    }

    public void setPublicadoEn(Integer publicadoEn) {
        this.publicadoEn = publicadoEn;
    }

    public String getInternalId() {
        return this.internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}