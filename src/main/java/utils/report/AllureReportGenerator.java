package utils.report;


import org.apache.commons.io.FileUtils;
import utils.OSUtils;
import utils.TerminalUtils;
import utils.TimeManager;
import utils.logs.LogsManager;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static utils.dataReader.PropertyReader.getProperty;
import static utils.report.AllureConstants.HISTORY_FOLDER;
import static utils.report.AllureConstants.RESULTS_HISTORY_FOLDER;

public class AllureReportGenerator {
        //Generate Allure report
        //--single-file - generate single file report
        public static void generateReports(boolean isSingleFile) {
            Path outputFolder = isSingleFile ? AllureConstants.REPORT_PATH : AllureConstants.FULL_REPORT_PATH;
            // allure generate -o reports --single-file --clean
            List<String> command = new ArrayList<>(List.of(
                    AllureBinaryManager.getExecutable().toString(),  //windows
                    "generate",
                    AllureConstants.RESULTS_FOLDER.toString(),  // mac/linux
                    "-o", outputFolder.toString(),
                    "--clean"
            ));
            if (isSingleFile) command.add("--single-file");
            TerminalUtils.executeTerminalCommand(command.toArray(new String[0]));
        }

        //rename report file to AllureReport_timestamp.html
        public static String renameReport() {
            String newFileName = AllureConstants.REPORT_PREFIX + TimeManager.getTimestamp() + AllureConstants.REPORT_EXTENSION;
            FileUtilss.FileUtils.renameFile(AllureConstants.REPORT_PATH.resolve("index.html").toString(), newFileName);

            return newFileName;

        }

        //open Allure report in browser
        public static void openReport(String reportFileName) {
            if (!getProperty("executionType").toLowerCase().contains("local")) return;

            Path reportPath = AllureConstants.REPORT_PATH.resolve(reportFileName);
            switch (OSUtils.getCurrentOS()) {
                case WINDOWS -> TerminalUtils.executeTerminalCommand("cmd.exe", "/c", "start", reportPath.toString());
                case MAC, LINUX -> TerminalUtils.executeTerminalCommand("open", reportPath.toString());
                default -> LogsManager.warn("Opening Allure Report is not supported on this OS.");
            }
        }

        //copy history folder to results folder
        public static void copyHistory() {
            try {
                FileUtils.copyDirectory(HISTORY_FOLDER.toFile(), RESULTS_HISTORY_FOLDER.toFile());
            } catch (Exception e) {
                LogsManager.error("Error copying history files", e.getMessage());
            }
        }

    }

