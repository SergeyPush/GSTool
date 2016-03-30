package com.infopulse.gst.autotest.MetadataManagement;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CreateModule extends GSTprereq {


    @Test
    public void test001CreateModule() throws Exception {
        // Navigate to Metadata Management view

        $(By.xpath(".//*[@id='topNaviForm:topNaviSelect']")).selectOption("IT-Grundschutz");

        $(By.xpath(".//*[@id='naviForm:metaDataTabId']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='naviForm:metaDataTabId']")).click();

        $("#hierarchyDisabled").waitUntil(present, 40000);

        //Add New Metadata item

        $("#addElementEnabled").waitUntil(enabled, 35000).click();


        $(By.xpath(".//*[@id='newMetaDataForm:targetObjectType']")).waitUntil(enabled, 10000).selectOption("Module");

        $(By.xpath(".//*[@id='newMetaDataForm:yes']")).waitUntil(enabled, 6000).click();

        $("#newMetaDataPanelHeader").waitUntil(disappear, 10000);

        $(By.xpath(".//*[@id='currentObjectForm:alteredPanel']")).waitUntil(text("New"), 10000);

        //Fill-out Basic data tab

        $(By.xpath(".//*[@id='moduleForm:name']")).waitUntil(present, 10000).sendKeys("AutoModule");

        $(By.xpath(".//*[@id='moduleForm:catalog_module']")).selectOption("Network");

        $(By.xpath(".//*[@id='moduleForm:num']")).val("1");

        //Fill-out Metadata text Tab


        $(By.xpath(".//*[@id='moduleForm:metaDataText_lbl']")).click();

        $(By.xpath(".//*[@id='moduleForm:_descriptionTextArea_ifr']")).sendKeys("AutoMetadataText");

        //Notepad Tab fill-up

        $(By.xpath(".//*[@id='moduleForm:notepad_lbl']")).click();

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_editor']")).sendKeys("AutoNotepad");

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_newDocumentRef']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_documentRefHeader']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_reference']")).sendKeys("AutoLink");

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_description']")).sendKeys("AutoDescription");

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_createReferenceButton']")).waitUntil(enabled, 10000).click();

        //Save

        $(By.xpath(".//*[@id='saveEnabled']")).click();

        //Check data

        $(By.partialLinkText("AutoModule")).waitUntil(visible, 10000);

        //Notepad check

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_editor']")).shouldHave(text("AutoNotepad"));

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_documentRefTable:innerd']")).shouldHave(text("AutoLink"));

        $(By.xpath(".//*[@id='moduleForm:moduleNotepad_documentRefTable:innerd']")).shouldHave(text("AutoDescription"));

        //Metadata text Check

        $(By.xpath(".//*[@id='moduleForm:metaDataText_lbl']")).waitUntil(enabled, 10000).click();

        switchTo().frame("moduleForm:_descriptionTextArea_ifr");
        $(By.xpath("//p")).shouldHave(text("AutoMetadataText"));
        switchTo().defaultContent();


        //BasicData check

        $(By.xpath(".//*[@id='moduleForm:baseData_lbl']")).click();

        $(By.xpath(".//*[@id='moduleForm:name']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='moduleForm:name']")).shouldHave(value("AutoModule"));

        $(By.xpath(".//table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input")).shouldHave(value("uM 4"));

        $(By.xpath(".//*[@id='moduleForm:num']")).shouldHave(value("1"));

    }

    @Test
    public void test002LinkSubtypes() throws Exception {
        //Link Subtypes


        $(By.xpath(".//*[@id='subtypeEnabled']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='subtype_panelHeader']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='subtype_panel_mpBForm:subtype_panel_dataTable:0:subtype_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='subtype_panel_mpBForm:save_link']")).waitUntil(enabled, 8000).click();

        $(By.xpath(".//*[@id='subtype_panelHeader']")).waitUntil(disappears, 10000);

        //Check subtypes

        $(By.xpath(".//*[@id='moduleForm:subtypes_tab_lbl']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='moduleForm:subtypes:tb']//div[@class='no-wrap']")).waitUntil(present, 10000).shouldHave(text("Active Directory"));

    }

    @Test
    public void test003LinkSafeguards() throws Exception {

        //Link Safeguards

        $("#safeGuardEnabled").waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='safeguard_panelHeader']/span")).waitUntil(visible, 30000);

        $(By.xpath(".//*[@id='safeguard_panel_mpBForm:safeguard_panel_dataTable:0:safeguard_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='safeguard_panel_mpBForm:save_link']")).waitUntil(enabled, 10000).click();

        //check safeguards

        $(By.xpath(".//*[@id='safeguard_panelHeader']/span")).waitUntil(disappear, 30000);

        $(By.xpath(".//*[@id='moduleForm:safeguards_tab_lbl']")).click();

        $(By.xpath(".//*[@id='moduleForm:safeguards:tb']/tr/td[1]/div")).waitUntil(present, 10000).shouldHave(text("S 1.1"));

    }

    @Test
    public void test004LinkTreats() throws Exception {
        //Link threat

        $(By.xpath(".//*[@id='threatEnabled']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='threat_panelHeader']")).waitUntil(visible, 20000);

        $(By.xpath(".//*[@id='threat_panel_mpBForm:threat_panel_dataTable:0:threat_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='threat_panel_mpBForm:save_link']")).waitUntil(enabled, 10000).click();

        //Check threat

        $(By.xpath(".//*[@id='threat_panelHeader']")).waitUntil(disappear, 20000);

        $(By.xpath(".//*[@id='moduleForm:threats_tab_lbl']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='moduleForm:threats:tb']/tr/td[1]/div")).shouldHave(text("T 0.1"));


    }

    @Test
    public void test005UnlinkAll() throws Exception {
        //UnLink Subtypes

        $("#subtypeEnabled").waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='subtype_panelHeader']")).waitUntil(visible, 10000);

        $(By.xpath(".//*[@id='subtype_panel_mpBForm:subtype_panel_dataTable:0:subtype_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='subtype_panel_mpBForm:save_link']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='subtype_panelHeader']")).waitUntil(disappear, 20000);

        //UnLink Safeguards

        $(By.xpath(".//*[@id='safeGuardEnabled']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='safeguard_panelHeader']/span")).waitUntil(visible, 40000);

        $(By.xpath(".//*[@id='safeguard_panel_mpBForm:safeguard_panel_dataTable:0:safeguard_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='safeguard_panel_mpBForm:save_link']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='safeguard_panelHeader']/span")).waitUntil(disappear, 20000);

        //UnLink threat

        $(By.xpath(".//*[@id='threatEnabled']")).click();

        $(By.xpath(".//*[@id='threat_panelHeader']")).waitUntil(visible, 20000);

        $(By.xpath(".//*[@id='threat_panel_mpBForm:threat_panel_dataTable:0:threat_panel_richColumn0']/div/input")).click();

        $(By.xpath(".//*[@id='threat_panel_mpBForm:save_link']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='threat_panelHeader']")).waitUntil(disappear, 20000);

    }

    @Test
    public void test006Delete() throws Exception {

        //Delete

        $(By.xpath(".//*[@id='deleteElementEnabled']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='genericConfirmPanelYes']")).waitUntil(enabled, 10000).click();

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).waitUntil(present, 20000);

        $(By.xpath(".//*[@id='footerForm:message']/dt/span")).shouldHave(text("Item successfully deleted"));

        $(By.partialLinkText("AutoModule")).waitUntil(disappear, 10000);

    }
}
