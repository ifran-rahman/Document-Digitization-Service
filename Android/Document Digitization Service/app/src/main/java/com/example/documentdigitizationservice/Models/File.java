package com.example.documentdigitizationservice.Models;

import java.util.Date;

public class File {
    private String FileName;
    private String FileUrl;
    private Date UploadDate;
    private Date ArchiveDate;

    public File(String fileName) {
        FileName = fileName;
    }

    public File(String fileName, String fileUrl, Date uploadDate, Date archiveDate) {
        FileName = fileName;
        FileUrl = fileUrl;
        UploadDate = uploadDate;
        ArchiveDate = archiveDate;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Date getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        UploadDate = uploadDate;
    }
}
