package com.institutosermelhor.ManagerCore.controller.Dtos;

import com.institutosermelhor.ManagerCore.util.ReportType;

public record ReportDto(String id, String fileName, ReportType reportType) {

}
