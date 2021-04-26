package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="experts")
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column
    private LocalDate created_at;

    @Column
    private LocalDate update_at;

    @Column
    private String estado_motivo;

    @Column
    private String disponibilidad;

    @Column
    private String modalidad;

    @Column
    private Boolean autonomo;

    @Column
    private String contacto_telefono;

    @Column
    private String contacto_email;

    @Column
    private String contacto_ciudad;

    @Column
    private String contacto_linkedin;

    @Column
    private String condiciones_porcentaje;

    @Column
    private String condiciones_precio_hora;

    @Column
    private Integer puntuacion;

    @Column
    private String nif;

    @Column
    private String credenciales_correo;

    @Column
    private String credenciales_correo_password;

    @Column
    private String credenciales_zoom;

    @Column
    private String credenciales_zoom_password;

    @Column
    private String fichero_foto;

    @Column
    private String fichero_cv;

    @Column
    private String observaciones;

    @Column
    private String origen;

    @Column
    private String estado;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "experts_tags",
            joinColumns = {@JoinColumn(name = "expert_id" )},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
        @JsonIgnoreProperties("experts")
    private List<Tag> tags = new ArrayList<Tag>();


    public Expert() {
    }

    public Expert(String nombre, LocalDate created_at, LocalDate update_at, String estado_motivo, String disponibilidad, String modalidad, Boolean autonomo, String contacto_telefono, String contacto_email, String contacto_ciudad, String contacto_linkedin, String condiciones_porcentaje, String condiciones_precio_hora, Integer puntuacion, String nif, String credenciales_correo, String credenciales_correo_password, String credenciales_zoom, String credenciales_zoom_password, String fichero_foto, String fichero_cv, String observaciones, String origen, String estado) {
        this.nombre = nombre;
        this.created_at = created_at;
        this.update_at = update_at;
        this.estado_motivo = estado_motivo;
        this.disponibilidad = disponibilidad;
        this.modalidad = modalidad;
        this.autonomo = autonomo;
        this.contacto_telefono = contacto_telefono;
        this.contacto_email = contacto_email;
        this.contacto_ciudad = contacto_ciudad;
        this.contacto_linkedin = contacto_linkedin;
        this.condiciones_porcentaje = condiciones_porcentaje;
        this.condiciones_precio_hora = condiciones_precio_hora;
        this.puntuacion = puntuacion;
        this.nif = nif;
        this.credenciales_correo = credenciales_correo;
        this.credenciales_correo_password = credenciales_correo_password;
        this.credenciales_zoom = credenciales_zoom;
        this.credenciales_zoom_password = credenciales_zoom_password;
        this.fichero_foto = fichero_foto;
        this.fichero_cv = fichero_cv;
        this.observaciones = observaciones;
        this.origen = origen;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }

    public String getEstado_motivo() {
        return estado_motivo;
    }

    public void setEstado_motivo(String estado_motivo) {
        this.estado_motivo = estado_motivo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Boolean getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Boolean autonomo) {
        this.autonomo = autonomo;
    }

    public String getContacto_telefono() {
        return contacto_telefono;
    }

    public void setContacto_telefono(String contacto_telefono) {
        this.contacto_telefono = contacto_telefono;
    }

    public String getContacto_email() {
        return contacto_email;
    }

    public void setContacto_email(String contacto_email) {
        this.contacto_email = contacto_email;
    }

    public String getContacto_ciudad() {
        return contacto_ciudad;
    }

    public void setContacto_ciudad(String contacto_ciudad) {
        this.contacto_ciudad = contacto_ciudad;
    }

    public String getContacto_linkedin() {
        return contacto_linkedin;
    }

    public void setContacto_linkedin(String contacto_linkedin) {
        this.contacto_linkedin = contacto_linkedin;
    }

    public String getCondiciones_porcentaje() {
        return condiciones_porcentaje;
    }

    public void setCondiciones_porcentaje(String condiciones_porcentaje) {
        this.condiciones_porcentaje = condiciones_porcentaje;
    }

    public String getCondiciones_precio_hora() {
        return condiciones_precio_hora;
    }

    public void setCondiciones_precio_hora(String condiciones_precio_hora) {
        this.condiciones_precio_hora = condiciones_precio_hora;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCredenciales_correo() {
        return credenciales_correo;
    }

    public void setCredenciales_correo(String credenciales_correo) {
        this.credenciales_correo = credenciales_correo;
    }

    public String getCredenciales_correo_password() {
        return credenciales_correo_password;
    }

    public void setCredenciales_correo_password(String credenciales_correo_password) {
        this.credenciales_correo_password = credenciales_correo_password;
    }

    public String getCredenciales_zoom() {
        return credenciales_zoom;
    }

    public void setCredenciales_zoom(String credenciales_zoom) {
        this.credenciales_zoom = credenciales_zoom;
    }

    public String getCredenciales_zoom_password() {
        return credenciales_zoom_password;
    }

    public void setCredenciales_zoom_password(String credenciales_zoom_password) {
        this.credenciales_zoom_password = credenciales_zoom_password;
    }

    public String getFichero_foto() {
        return fichero_foto;
    }

    public void setFichero_foto(String fichero_foto) {
        this.fichero_foto = fichero_foto;
    }

    public String getFichero_cv() {
        return fichero_cv;
    }

    public void setFichero_cv(String fichero_cv) {
        this.fichero_cv = fichero_cv;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "Expert{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", created_at=" + created_at +
                ", update_at=" + update_at +
                ", estado_motivo='" + estado_motivo + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", autonomo=" + autonomo +
                ", contacto_telefono=" + contacto_telefono +
                ", contacto_email='" + contacto_email + '\'' +
                ", contacto_ciudad='" + contacto_ciudad + '\'' +
                ", contacto_linkedin='" + contacto_linkedin + '\'' +
                ", condiciones_porcentaje='" + condiciones_porcentaje + '\'' +
                ", condiciones_precio_hora='" + condiciones_precio_hora + '\'' +
                ", puntuacion=" + puntuacion +
                ", nif='" + nif + '\'' +
                ", credenciales_correo='" + credenciales_correo + '\'' +
                ", credenciales_correo_password='" + credenciales_correo_password + '\'' +
                ", credenciales_zoom='" + credenciales_zoom + '\'' +
                ", credenciales_zoom_password='" + credenciales_zoom_password + '\'' +
                ", fichero_foto='" + fichero_foto + '\'' +
                ", fichero_cv='" + fichero_cv + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", origen='" + origen + '\'' +
                ", estado=" + estado +
                ", tags=" + tags +
                '}';
    }
}
