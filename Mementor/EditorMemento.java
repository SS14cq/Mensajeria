class EditorMemento {
    private final String mensaje;
    private final String remitente;

    public EditorMemento(String mensaje, String remitente) {
        this.mensaje = mensaje;
        this.remitente = remitente;
    }
    public String getMensaje() { return mensaje; }
    public String getRemitente() { return remitente; }
}