public class PrintJob {
    private String documentName;
    private int pageCount;

    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    public String getDocumentName() {return documentName;}

    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return String.format("[Document: %s, Pages: %d]", documentName, pageCount); // Placeholder
    }
}
