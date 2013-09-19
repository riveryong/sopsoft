--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      sopsoft.net
-- Project :      sopsoft-MemberManage-DB.dm1
-- Author :       yangyudong
--
-- Date Created : Sunday, August 25, 2013 22:54:40
-- Target DBMS : MySQL 5.x
--

-- 
-- TABLE: t_Bonus_Exchange_History 
--

CREATE TABLE t_Bonus_Exchange_History(
    Exchange_History_ID    INT              AUTO_INCREMENT,
    Company_ID             INT              NOT NULL,
    Store_ID               INT,
    Store_Name             VARCHAR(100),
    Member_ID              INT,
    Member_No              VARCHAR(100),
    Operator_No            VARCHAR(50),
    Exchange_DateTime      DATETIME,
    Bonus_Num              INT,
    Money_Num              DOUBLE(18, 0),
    Surplus_Bonus          INT,
    Surplus_Money          DOUBLE(18, 0),
    Bonus_Type             INT              NOT NULL,
    Comment                VARCHAR(1000),
    Update_DateTime        DATETIME,
    State                  INT              DEFAULT 0 NOT NULL,
    Delete_No              VARCHAR(35),
    PRIMARY KEY (Exchange_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Bonus_Exchange_Product_Detail 
--

CREATE TABLE t_Bonus_Exchange_Product_Detail(
    Exchange_Detail_ID      INT              AUTO_INCREMENT,
    Exchange_History_ID     INT              NOT NULL,
    Company_ID              INT,
    Store_ID                INT,
    Store_Name              VARCHAR(100),
    Operator_No             VARCHAR(50),
    Product_Info_No         VARCHAR(100),
    Product_Name            VARCHAR(300),
    Product_Group_Name      VARCHAR(300),
    Deal_Price              DOUBLE(18, 0),
    Product_Bonus           INT,
    Exchange_Bonus          INT,
    Bouns_Exchange_Count    INT,
    Exchange_DateTime       DATETIME,
    Update_DateTime         DATETIME,
    State                   INT              DEFAULT 0,
    Delete_No               VARCHAR(35),
    PRIMARY KEY (Exchange_Detail_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Business_Log 
--

CREATE TABLE t_Business_Log(
    Log_ID         INT             AUTO_INCREMENT,
    Company_ID     INT             NOT NULL,
    Store_ID       INT,
    Store_Name     VARCHAR(100),
    Operator_No    VARCHAR(50),
    Action_Time    DATETIME        NOT NULL,
    Action_Type    INT,
    Action_ID      VARCHAR(100)    NOT NULL,
    Action_Name    VARCHAR(100),
    Recode_ID      INT,
    Msg            TEXT,
    State          INT             DEFAULT 0,
    Delete_No      VARCHAR(35),
    PRIMARY KEY (Log_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Call_History 
--

CREATE TABLE t_Call_History(
    Call_History_ID    INT              AUTO_INCREMENT,
    Operator_ID        INT              NOT NULL,
    Company_ID         INT              NOT NULL,
    Store_ID           INT,
    Member_ID          INT,
    Phone_No           VARCHAR(20),
    Call_Type          INT,
    Call_Start_Time    DATETIME,
    Call_End_Time      DATETIME,
    Call_Length        INT,
    Comment            VARCHAR(1500),
    Update_DateTime    DATETIME,
    State              INT              DEFAULT 0,
    Delete_No          VARCHAR(35),
    PRIMARY KEY (Call_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Company_BuySms_History 
--

CREATE TABLE t_Company_BuySms_History(
    BuySms_History_ID    INT              AUTO_INCREMENT,
    Company_ID           INT              NOT NULL,
    Pre_Sms_Count        INT,
    BuySms_Fee           DOUBLE(18, 0),
    Current_Sms_Count    INT,
    BuySms_Count         INT,
    Company_Balance      DOUBLE(18, 0),
    BuySms_Datetime      DATETIME,
    Operator_No          VARCHAR(100),
    State                INT              DEFAULT 0 NOT NULL,
    Delete_No            VARCHAR(35),
    PRIMARY KEY (BuySms_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Company_Charge_History 
--

CREATE TABLE t_Company_Charge_History(
    Company_Charge_History_ID    INT              AUTO_INCREMENT,
    Company_ID                   INT              NOT NULL,
    Charge_Money                 DOUBLE(18, 0),
    Company_Money                DOUBLE(18, 0),
    Charge_DateTime              DATETIME,
    Charge_Type                  VARCHAR(50),
    Charge_State                 INT,
    Comment                      VARCHAR(1000)    NOT NULL,
    Operator_Saas_Admin          VARCHAR(50),
    Operator_Company_Operator    VARCHAR(50),
    State                        INT              DEFAULT 0 NOT NULL,
    Delete_No                    VARCHAR(35),
    PRIMARY KEY (Company_Charge_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Company_Info 
--

CREATE TABLE t_Company_Info(
    Company_ID                    INT              AUTO_INCREMENT,
    Company_No                    VARCHAR(100)     NOT NULL,
    System_Show_Name              VARCHAR(100),
    Sys_Version_ID                INT,
    Sys_Version                   VARCHAR(100),
    Sys_Version_Display_Order     INT,
    Max_MemberCount               INT              DEFAULT 200,
    Due_Datetime                  DATETIME,
    Company_Balance               DOUBLE(18, 0),
    Company_Name                  VARCHAR(50),
    Link_Man_Name                 VARCHAR(50),
    Link_Man_Phone                VARCHAR(50),
    Link_Man_Mail                 VARCHAR(70),
    Link_Man_QQ                   VARCHAR(15),
    Province                      VARCHAR(150),
    City                          VARCHAR(150),
    District                      VARCHAR(150),
    Address                       VARCHAR(300),
    Comment                       VARCHAR(2000),
    Reg_DateTime                  DATETIME         NOT NULL,
    Company_Status                INT,
    Can_Send_Sms_Count            INT              DEFAULT 0,
    Custom_Property1_Name         VARCHAR(50),
    Custom_Property4_Name         VARCHAR(50),
    Custom_Property2_Name         VARCHAR(50),
    Custom_Property3_Name         VARCHAR(50),
    Custom_Property5_Name         VARCHAR(50),
    Custom_Property6_Name         VARCHAR(50),
    Sms_Template_AddMember        VARCHAR(400),
    Sms_Template_Charge           VARCHAR(400),
    Sms_Template_Deal_Moeny       VARCHAR(400),
    Sms_Template_Deal_Product     VARCHAR(400),
    Sms_Template_Deal_Times       VARCHAR(400),
    Sms_Template_Bonus_Money      VARCHAR(400),
    Sms_Template_Bonus_Product    VARCHAR(400),
    Reg_Ip                        VARCHAR(30),
    Reg_From                      INT,
    Record_State                  INT              DEFAULT 0,
    Delete_No                     VARCHAR(35),
    Is_MembersSearch_Self         INT              DEFAULT 0,
    MemberSearch_Href             VARCHAR(25),
    PRIMARY KEY (Company_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Company_Update_History 
--

CREATE TABLE t_Company_Update_History(
    Update_History_ID          INT              AUTO_INCREMENT,
    Company_ID                 INT              NOT NULL,
    Pre_Version                VARCHAR(50),
    Pre_Max_MemberCount        INT,
    Current_Version            VARCHAR(50),
    Current_Max_MemberCount    INT,
    Due_Datetime               DATETIME,
    Update_Fee                 DOUBLE(18, 0),
    Company_Balance            DOUBLE(18, 0),
    Pay_Type                   VARCHAR(50),
    Update_Datetime            DATETIME,
    Operator_No                VARCHAR(100),
    Comment                    VARCHAR(500),
    State                      INT              DEFAULT 0 NOT NULL,
    Delete_No                  VARCHAR(35),
    PRIMARY KEY (Update_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Customer_DaiLi_Info 
--

CREATE TABLE t_Customer_DaiLi_Info(
    DaiLi_ID         INT    AUTO_INCREMENT,
    Company_ID       INT    NOT NULL,
    DaiLiShang_ID    INT    NOT NULL,
    PRIMARY KEY (DaiLi_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_DaiLiShang_Info 
--

CREATE TABLE t_DaiLiShang_Info(
    DaiLiShang_ID      INT              AUTO_INCREMENT,
    DaiLi_No           VARCHAR(15)      NOT NULL,
    DaiLi_Password     VARCHAR(30),
    Link_Man           VARCHAR(30),
    Phone              VARCHAR(20),
    City               VARCHAR(30),
    DaiLi_Address      VARCHAR(100),
    Create_DateTime    DATETIME,
    Comment            VARCHAR(1000),
    PRIMARY KEY (DaiLiShang_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Deal_Detail 
--

CREATE TABLE t_Deal_Detail(
    Deal_Detail_ID        INT              AUTO_INCREMENT,
    Deal_History_ID       INT              NOT NULL,
    Company_ID            INT,
    Store_ID              INT,
    Store_Name            VARCHAR(100),
    Member_ID             INT,
    Member_No             VARCHAR(100),
    Guide_ID              INT,
    Guide_No              VARCHAR(50)      DEFAULT '',
    Guide_Name            VARCHAR(50)      DEFAULT '',
    Guide2_ID             INT,
    Guide2_No             VARCHAR(50)      DEFAULT '',
    Guide2_Name           VARCHAR(50)      DEFAULT '',
    Guide3_ID             INT,
    Guide3_No             VARCHAR(50)      DEFAULT '',
    Guide3_Name           VARCHAR(50)      DEFAULT '',
    Guide4_ID             INT,
    Guide4_No             VARCHAR(50)      DEFAULT '',
    Guide4_Name           VARCHAR(50)      DEFAULT '',
    Operator_No           VARCHAR(50),
    Product_Info_No       VARCHAR(100),
    Product_Name          VARCHAR(300),
    Product_Group_Name    VARCHAR(300),
    Original_Price        DOUBLE(18, 0),
    Deal_Price            DOUBLE(18, 0),
    Buy_Count             INT,
    Total_Price           DOUBLE(18, 0),
    Deal_DateTime         DATETIME,
    Update_DateTime       DATETIME,
    State                 INT              DEFAULT 0,
    Delete_No             VARCHAR(35),
    PRIMARY KEY (Deal_Detail_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Event_Alert 
--

CREATE TABLE t_Event_Alert(
    Event_ID          INT              AUTO_INCREMENT,
    Title             VARCHAR(300),
    Content           VARCHAR(1000),
    Alert_DateTime    DATETIME,
    Event_Status      INT,
    Is_Sms_Alert      INT,
    Alert_Mobile      VARCHAR(300),
    Is_Send_Sms       INT,
    Store_ID          INT,
    Company_ID        INT,
    State             INT              DEFAULT 0,
    Delete_No         VARCHAR(35),
    PRIMARY KEY (Event_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Member_Charge_History 
--

CREATE TABLE t_Member_Charge_History(
    Charge_History_ID    INT              AUTO_INCREMENT,
    Company_ID           INT              NOT NULL,
    Store_ID             INT,
    Store_Name           VARCHAR(100),
    Member_ID            INT,
    Member_No            VARCHAR(100)     NOT NULL,
    Operator_No          VARCHAR(50),
    Charge_DateTime      DATETIME,
    Charge_Money         DOUBLE(18, 0),
    Balance              DOUBLE(18, 0),
    Charge_Bonus         INT,
    Bonus                INT,
    Charge_Deal_Time     INT,
    Deal_Time            INT,
    YingShouCash         DOUBLE(18, 0),
    Comment              VARCHAR(1000),
    State                INT              DEFAULT 0,
    Delete_No            VARCHAR(35),
    PRIMARY KEY (Charge_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Member_Deal_History 
--

CREATE TABLE t_Member_Deal_History(
    Deal_History_ID        INT              AUTO_INCREMENT,
    Company_ID             INT              NOT NULL,
    Store_ID               INT,
    Store_Name             VARCHAR(100),
    Member_ID              INT,
    Member_No              VARCHAR(100),
    Operator_No            VARCHAR(50),
    Guide_ID               INT,
    Guide_No               VARCHAR(50)      DEFAULT '',
    Guide_Name             VARCHAR(50)      DEFAULT '',
    Guide2_ID              INT,
    Guide2_No              VARCHAR(50)      DEFAULT '',
    Guide2_Name            VARCHAR(50)      DEFAULT '',
    Guide3_ID              INT,
    Guide3_No              VARCHAR(50)      DEFAULT '',
    Guide3_Name            VARCHAR(50)      DEFAULT '',
    Guide4_ID              INT,
    Guide4_No              VARCHAR(50)      DEFAULT '',
    Guide4_Name            VARCHAR(50)      DEFAULT '',
    Deal_DateTime          DATETIME,
    YingShou_Money         DOUBLE(18, 0),
    ZheHou_Money           DOUBLE(18, 0),
    YouHui_Money           DOUBLE(18, 0),
    ShiShou_Cash           DOUBLE(18, 0),
    ShouDao_cash           DOUBLE(18, 0),
    LooseCharge            DOUBLE(18, 0),
    KouChu_Card_Balance    DOUBLE(18, 0),
    Leave_Balance          DOUBLE(18, 0),
    KouChu_Deal_Time       INT,
    Leave_Deal_Time        INT,
    Get_Bonus              INT,
    Pay_Type               INT              NOT NULL,
    Comment                VARCHAR(1500),
    Update_DateTime        DATETIME,
    State                  INT              DEFAULT 0 NOT NULL,
    Delete_No              VARCHAR(35),
    PRIMARY KEY (Deal_History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Member_Discount_Info 
--

CREATE TABLE t_Member_Discount_Info(
    Member_Discount_Info_ID    INT              AUTO_INCREMENT,
    Company_ID                 INT              NOT NULL,
    Store_ID                   INT              NOT NULL,
    Member_Grade_ID            INT              NOT NULL,
    Discount_Percent           DOUBLE(18, 0),
    Is_Default_Discount        INT,
    Update_DateTime            DATETIME,
    Operator_No                VARCHAR(50),
    State                      INT              DEFAULT 0,
    Delete_No                  VARCHAR(35),
    PRIMARY KEY (Member_Discount_Info_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Member_Grade 
--

CREATE TABLE t_Member_Grade(
    Member_Grade_ID     INT              AUTO_INCREMENT,
    Company_ID          INT              NOT NULL,
    Grade_Name          VARCHAR(100),
    Discount_Percent    DOUBLE(18, 0),
    Update_DateTime     DATETIME,
    Operator_No         VARCHAR(50),
    State               INT              DEFAULT 0,
    Delete_No           VARCHAR(35),
    PRIMARY KEY (Member_Grade_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Member_Info 
--

CREATE TABLE t_Member_Info(
    Member_ID               INT              AUTO_INCREMENT,
    Company_ID              INT              NOT NULL,
    Store_ID                INT              NOT NULL,
    Member_Grade_ID         INT,
    Member_No               VARCHAR(100)     NOT NULL,
    Member_Name             VARCHAR(60),
    Member_Password         VARCHAR(60),
    Member_Photo            VARCHAR(300),
    Balance                 DOUBLE(18, 0),
    Leaving_Deal_time       INT,
    Bouns                   INT,
    Sex                     INT,
    Tel                     VARCHAR(200),
    Mobile_No               VARCHAR(30),
    Email                   VARCHAR(60),
    Identity_Type           INT,
    Identity_No             VARCHAR(100),
    Instant_Message         VARCHAR(50),
    Birthday_Year           VARCHAR(4),
    Birthday_Month_Day      VARCHAR(4),
    Province                VARCHAR(150),
    City                    VARCHAR(150),
    District                VARCHAR(150),
    Address                 VARCHAR(500),
    Company                 VARCHAR(600),
    Custom_Property1        VARCHAR(2000),
    Custom_Property2        VARCHAR(2000),
    Custom_Property3        VARCHAR(2000),
    Custom_Property4        VARCHAR(2000),
    Custom_Property5        VARCHAR(2000),
    Custom_Property6        VARCHAR(2000),
    Comment                 VARCHAR(1000),
    Member_State            INT,
    Validity_Date           DATETIME,
    Reg_Date                DATETIME,
    Update_DateTime         DATETIME,
    Operator_No             VARCHAR(50),
    IS_Share_Member_Info    INT,
    State                   INT              DEFAULT 0,
    Delete_No               VARCHAR(35),
    PRIMARY KEY (Member_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_NotePad 
--

CREATE TABLE t_NotePad(
    NotePad_ID          INT             AUTO_INCREMENT,
    Company_ID          INT             NOT NULL,
    Title               VARCHAR(200),
    Content             TEXT,
    Member_No           VARCHAR(100),
    State               INT             DEFAULT 0 NOT NULL,
    Delete_No           VARCHAR(35),
    IS_Share_NotePad    INT,
    Operator_No         VARCHAR(100),
    Update_DateTime     DATETIME,
    Create_DateTime     DATETIME,
    PRIMARY KEY (NotePad_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Operator_Info 
--

CREATE TABLE t_Operator_Info(
    Operator_ID              INT             AUTO_INCREMENT,
    Company_ID               INT             NOT NULL,
    Store_ID                 INT             NOT NULL,
    Store_Name               VARCHAR(100),
    Operator_No              VARCHAR(50)     NOT NULL,
    Operator_Password        VARCHAR(64),
    Operator_Type            INT,
    Operator_Menu_Name       TEXT,
    Operator_Menu_Right      TEXT,
    Operator_Action_Name     TEXT,
    Operator_Action_Right    TEXT,
    Login_Error_Num          INT             DEFAULT 0 NOT NULL,
    Operator_State           INT             DEFAULT 0 NOT NULL,
    Operator_Model_Right     TEXT,
    Update_Operator_No       VARCHAR(50),
    Create_DateTime          DATETIME,
    Update_DateTime          DATETIME,
    Sys_Theme                VARCHAR(30),
    State                    INT             DEFAULT 0,
    Delete_No                VARCHAR(35),
    PRIMARY KEY (Operator_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Operator_Login_History 
--

CREATE TABLE t_Operator_Login_History(
    Login_ID         INT             AUTO_INCREMENT,
    Company_ID       INT             NOT NULL,
    Company_No       VARCHAR(100),
    Store_ID         INT,
    Store_Name       VARCHAR(100),
    Operator_No      VARCHAR(50)     NOT NULL,
    Operator_Type    INT,
    Login_Time       DATETIME        NOT NULL,
    Login_Type       INT,
    IP_Address       VARCHAR(64),
    Browser_Info     VARCHAR(100),
    Login_From       INT,
    State            INT             DEFAULT 0 NOT NULL,
    Delete_No        VARCHAR(35),
    PRIMARY KEY (Login_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Product_Group 
--

CREATE TABLE t_Product_Group(
    Product_Group_ID    INT              AUTO_INCREMENT,
    Company_ID          INT              NOT NULL,
    Group_Name          VARCHAR(300),
    Comment             VARCHAR(1000),
    Update_DateTime     DATETIME,
    Operator_No         VARCHAR(50),
    State               INT              DEFAULT 0 NOT NULL,
    Delete_No           VARCHAR(35),
    PRIMARY KEY (Product_Group_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Product_Info 
--

CREATE TABLE t_Product_Info(
    Product_Info_ID     INT              AUTO_INCREMENT,
    Company_ID          INT              NOT NULL,
    Product_Group_ID    INT              NOT NULL,
    Product_Info_No     VARCHAR(50),
    Product_Name        VARCHAR(300),
    Comment             VARCHAR(1000),
    Update_DateTime     DATETIME,
    Operator_No         VARCHAR(50),
    State               INT              DEFAULT 0 NOT NULL,
    Delete_No           VARCHAR(35),
    PRIMARY KEY (Product_Info_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Product_Sale_Info 
--

CREATE TABLE t_Product_Sale_Info(
    Product_Sale_ID      INT              AUTO_INCREMENT,
    Company_ID           INT              NOT NULL,
    Product_Info_ID      INT              NOT NULL,
    Store_ID             INT              NOT NULL,
    Sale_Price           DOUBLE(18, 0),
    Purchase_Price       DOUBLE(18, 0),
    Is_Bonus_Exchange    INT,
    Product_State        INT,
    Exchange_Bouns       INT,
    Comment              VARCHAR(1000),
    Reserve_Count        INT,
    Update_DateTime      DATETIME,
    Operator_No          VARCHAR(50),
    State                INT              DEFAULT 0 NOT NULL,
    Delete_No            VARCHAR(35),
    PRIMARY KEY (Product_Sale_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Saas_Admin 
--

CREATE TABLE t_Saas_Admin(
    Admin_ID           INT            AUTO_INCREMENT,
    Admin_No           VARCHAR(30)    NOT NULL,
    Admin_Password     VARCHAR(60),
    Admin_Type         INT,
    Login_Error_Num    INT            DEFAULT 0 NOT NULL,
    Create_DateTime    DATETIME,
    PRIMARY KEY (Admin_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Shopping_Guide 
--

CREATE TABLE t_Shopping_Guide(
    Guide_ID             INT              AUTO_INCREMENT,
    Company_ID           INT              NOT NULL,
    Store_ID             INT              NOT NULL,
    Guide_No             VARCHAR(50),
    Guide_Name           VARCHAR(50),
    Sales_Commissions    DOUBLE(18, 0),
    Comment              VARCHAR(1000),
    Update_DateTime      DATETIME,
    Operator_No          VARCHAR(50),
    State                INT              DEFAULT 0 NOT NULL,
    Delete_No            VARCHAR(35),
    PRIMARY KEY (Guide_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Sms_Send_History 
--

CREATE TABLE t_Sms_Send_History(
    History_ID            INT             AUTO_INCREMENT,
    Company_ID            INT             NOT NULL,
    Store_ID              INT,
    Store_Name            VARCHAR(100),
    Receive_Mobile_No     TEXT,
    Send_DateTime         DATETIME,
    Mobile_Num            INT,
    KouChu_Send_Num       INT,
    Current_Sms_Count     INT,
    Sms_Content           VARCHAR(500),
    Sms_Content_Length    INT,
    Sms_Type              INT,
    Operator_No           VARCHAR(50),
    Send_State            INT,
    Sms_Prior_Level       INT,
    Create_Datetime       DATETIME,
    Error_Code            VARCHAR(10),
    Error_Info            VARCHAR(300),
    State                 INT             NOT NULL,
    Delete_No             VARCHAR(35),
    Update_DateTime       DATETIME,
    PRIMARY KEY (History_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Store_Info 
--

CREATE TABLE t_Store_Info(
    Store_ID                           INT              AUTO_INCREMENT,
    Company_ID                         INT              NOT NULL,
    Store_Name                         VARCHAR(100),
    Bonus_Ratio                        INT,
    Can_Modifi_Bonus                   INT,
    Can_Modifi_Money                   INT,
    Can_Modifi_Discount                INT,
    Report_Title                       VARCHAR(150),
    Report_Tel                         VARCHAR(60),
    Is_Create_Member_Print_Report      INT,
    Create_Member_Print_Report_Num     INT,
    Is_Bonus_Exchange_Print_Report     INT,
    Bonus_Exchange_Print_Report_Num    INT,
    Is_Deal_Print_Report               INT,
    Deal_Print_Report_Num              INT,
    Is_Charge_Print_Report             INT,
    Charge_Print_Report_Num            INT,
    Bonus_to_Money_Ratio               DOUBLE(18, 0),
    Pay_Type                           INT,
    Is_Send_NewMember_Sms              INT,
    Is_Send_Charge_Sms                 INT,
    Is_Send_BonusExchange_Sms          INT,
    Is_Send_Deal_Sms                   INT,
    Is_Auto_Send_Birthday_Sms          INT,
    IS_Share_Member_Info               INT,
    Sms_Send_Name                      VARCHAR(30),
    Update_DateTime                    DATETIME,
    Operator_No                        VARCHAR(50),
    Comment                            VARCHAR(1000),
    State                              INT              DEFAULT 0 NOT NULL,
    Delete_No                          VARCHAR(35),
    PRIMARY KEY (Store_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_Sys_Base_Info 
--

CREATE TABLE t_Sys_Base_Info(
    Sys_Base_Info_ID    INT    AUTO_INCREMENT,
    Sms_Count           INT,
    PRIMARY KEY (Sys_Base_Info_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_SysVersion_Info 
--

CREATE TABLE t_SysVersion_Info(
    SysVersion_Info_ID    INT              AUTO_INCREMENT,
    Version_No            VARCHAR(10),
    Display_Order         INT,
    Version_Name          VARCHAR(50),
    Max_MemberCount       INT,
    Monthly_Rent          DOUBLE(18, 0),
    PRIMARY KEY (SysVersion_Info_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- TABLE: t_WebService_LoginInfo 
--

CREATE TABLE t_WebService_LoginInfo(
    WebService_LoginInfo_ID    INT            AUTO_INCREMENT,
    Company_ID                 INT,
    Operator_ID                INT,
    Login_Auth_No              VARCHAR(64),
    Login_Auth_No_State        INT            NOT NULL,
    Login_DateTime             DATETIME,
    Client_IP                  VARCHAR(32),
    PRIMARY KEY (WebService_LoginInfo_ID)
)ENGINE=INNODB
COMMENT=''
;

-- 
-- INDEX: Ref2443 
--

CREATE INDEX Ref2443 ON t_Bonus_Exchange_History(Company_ID)
;
-- 
-- INDEX: Ref1627 
--

CREATE INDEX Ref1627 ON t_Bonus_Exchange_Product_Detail(Exchange_History_ID)
;
-- 
-- INDEX: Ref264 
--

CREATE INDEX Ref264 ON t_Call_History(Operator_ID)
;
-- 
-- INDEX: Ref2465 
--

CREATE INDEX Ref2465 ON t_Call_History(Company_ID)
;
-- 
-- INDEX: Ref2457 
--

CREATE INDEX Ref2457 ON t_Company_BuySms_History(Company_ID)
;
-- 
-- INDEX: Ref2455 
--

CREATE INDEX Ref2455 ON t_Company_Charge_History(Company_ID)
;
-- 
-- INDEX: Ref2454 
--

CREATE INDEX Ref2454 ON t_Company_Update_History(Company_ID)
;
-- 
-- INDEX: Ref3661 
--

CREATE INDEX Ref3661 ON t_Customer_DaiLi_Info(DaiLiShang_ID)
;
-- 
-- INDEX: Ref2462 
--

CREATE INDEX Ref2462 ON t_Customer_DaiLi_Info(Company_ID)
;
-- 
-- INDEX: Ref38 
--

CREATE INDEX Ref38 ON t_Deal_Detail(Deal_History_ID)
;
-- 
-- INDEX: Ref2435 
--

CREATE INDEX Ref2435 ON t_Member_Charge_History(Company_ID)
;
-- 
-- INDEX: Ref2444 
--

CREATE INDEX Ref2444 ON t_Member_Deal_History(Company_ID)
;
-- 
-- INDEX: Ref2446 
--

CREATE INDEX Ref2446 ON t_Member_Discount_Info(Company_ID)
;
-- 
-- INDEX: Ref1847 
--

CREATE INDEX Ref1847 ON t_Member_Discount_Info(Store_ID)
;
-- 
-- INDEX: Ref1226 
--

CREATE INDEX Ref1226 ON t_Member_Discount_Info(Member_Grade_ID)
;
-- 
-- INDEX: Ref2445 
--

CREATE INDEX Ref2445 ON t_Member_Grade(Company_ID)
;
-- 
-- INDEX: Ref1852 
--

CREATE INDEX Ref1852 ON t_Member_Info(Store_ID)
;
-- 
-- INDEX: Ref1253 
--

CREATE INDEX Ref1253 ON t_Member_Info(Member_Grade_ID)
;
-- 
-- INDEX: Ref2428 
--

CREATE INDEX Ref2428 ON t_Member_Info(Company_ID)
;
-- 
-- INDEX: Ref2463 
--

CREATE INDEX Ref2463 ON t_NotePad(Company_ID)
;
-- 
-- INDEX: Ref2439 
--

CREATE INDEX Ref2439 ON t_Operator_Info(Company_ID)
;
-- 
-- INDEX: Ref2460 
--

CREATE INDEX Ref2460 ON t_Operator_Login_History(Company_ID)
;
-- 
-- INDEX: Ref2436 
--

CREATE INDEX Ref2436 ON t_Product_Group(Company_ID)
;
-- 
-- INDEX: Ref77 
--

CREATE INDEX Ref77 ON t_Product_Info(Product_Group_ID)
;
-- 
-- INDEX: Ref2437 
--

CREATE INDEX Ref2437 ON t_Product_Info(Company_ID)
;
-- 
-- INDEX: Ref2451 
--

CREATE INDEX Ref2451 ON t_Product_Sale_Info(Company_ID)
;
-- 
-- INDEX: Ref625 
--

CREATE INDEX Ref625 ON t_Product_Sale_Info(Product_Info_ID)
;
-- 
-- INDEX: Ref1838 
--

CREATE INDEX Ref1838 ON t_Product_Sale_Info(Store_ID)
;
-- 
-- INDEX: Ref1842 
--

CREATE INDEX Ref1842 ON t_Shopping_Guide(Store_ID)
;
-- 
-- INDEX: Ref2441 
--

CREATE INDEX Ref2441 ON t_Shopping_Guide(Company_ID)
;
-- 
-- INDEX: Ref2459 
--

CREATE INDEX Ref2459 ON t_Sms_Send_History(Company_ID)
;
-- 
-- INDEX: Ref2434 
--

CREATE INDEX Ref2434 ON t_Store_Info(Company_ID)
;
-- 
-- TABLE: t_Bonus_Exchange_History 
--

ALTER TABLE t_Bonus_Exchange_History ADD CONSTRAINT Reft_Company_Info43 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Bonus_Exchange_Product_Detail 
--

ALTER TABLE t_Bonus_Exchange_Product_Detail ADD CONSTRAINT Reft_Bonus_Exchange_History27 
    FOREIGN KEY (Exchange_History_ID)
    REFERENCES t_Bonus_Exchange_History(Exchange_History_ID)
;


-- 
-- TABLE: t_Call_History 
--

ALTER TABLE t_Call_History ADD CONSTRAINT Reft_Operator_Info64 
    FOREIGN KEY (Operator_ID)
    REFERENCES t_Operator_Info(Operator_ID)
;

ALTER TABLE t_Call_History ADD CONSTRAINT Reft_Company_Info65 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Company_BuySms_History 
--

ALTER TABLE t_Company_BuySms_History ADD CONSTRAINT Reft_Company_Info57 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Company_Charge_History 
--

ALTER TABLE t_Company_Charge_History ADD CONSTRAINT Reft_Company_Info55 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Company_Update_History 
--

ALTER TABLE t_Company_Update_History ADD CONSTRAINT Reft_Company_Info54 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Customer_DaiLi_Info 
--

ALTER TABLE t_Customer_DaiLi_Info ADD CONSTRAINT Reft_DaiLiShang_Info61 
    FOREIGN KEY (DaiLiShang_ID)
    REFERENCES t_DaiLiShang_Info(DaiLiShang_ID)
;

ALTER TABLE t_Customer_DaiLi_Info ADD CONSTRAINT Reft_Company_Info62 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Deal_Detail 
--

ALTER TABLE t_Deal_Detail ADD CONSTRAINT Reft_Member_Deal_History8 
    FOREIGN KEY (Deal_History_ID)
    REFERENCES t_Member_Deal_History(Deal_History_ID)
;


-- 
-- TABLE: t_Member_Charge_History 
--

ALTER TABLE t_Member_Charge_History ADD CONSTRAINT Reft_Company_Info35 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Member_Deal_History 
--

ALTER TABLE t_Member_Deal_History ADD CONSTRAINT Reft_Company_Info44 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Member_Discount_Info 
--

ALTER TABLE t_Member_Discount_Info ADD CONSTRAINT Reft_Company_Info46 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;

ALTER TABLE t_Member_Discount_Info ADD CONSTRAINT Reft_Store_Info47 
    FOREIGN KEY (Store_ID)
    REFERENCES t_Store_Info(Store_ID)
;

ALTER TABLE t_Member_Discount_Info ADD CONSTRAINT Reft_Member_Grade26 
    FOREIGN KEY (Member_Grade_ID)
    REFERENCES t_Member_Grade(Member_Grade_ID)
;


-- 
-- TABLE: t_Member_Grade 
--

ALTER TABLE t_Member_Grade ADD CONSTRAINT Reft_Company_Info45 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Member_Info 
--

ALTER TABLE t_Member_Info ADD CONSTRAINT Reft_Store_Info52 
    FOREIGN KEY (Store_ID)
    REFERENCES t_Store_Info(Store_ID)
;

ALTER TABLE t_Member_Info ADD CONSTRAINT Reft_Member_Grade53 
    FOREIGN KEY (Member_Grade_ID)
    REFERENCES t_Member_Grade(Member_Grade_ID)
;

ALTER TABLE t_Member_Info ADD CONSTRAINT Reft_Company_Info28 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_NotePad 
--

ALTER TABLE t_NotePad ADD CONSTRAINT Reft_Company_Info63 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Operator_Info 
--

ALTER TABLE t_Operator_Info ADD CONSTRAINT Reft_Company_Info39 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Operator_Login_History 
--

ALTER TABLE t_Operator_Login_History ADD CONSTRAINT Reft_Company_Info60 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Product_Group 
--

ALTER TABLE t_Product_Group ADD CONSTRAINT Reft_Company_Info36 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Product_Info 
--

ALTER TABLE t_Product_Info ADD CONSTRAINT Reft_Product_Group7 
    FOREIGN KEY (Product_Group_ID)
    REFERENCES t_Product_Group(Product_Group_ID)
;

ALTER TABLE t_Product_Info ADD CONSTRAINT Reft_Company_Info37 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Product_Sale_Info 
--

ALTER TABLE t_Product_Sale_Info ADD CONSTRAINT Reft_Company_Info51 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;

ALTER TABLE t_Product_Sale_Info ADD CONSTRAINT Reft_Product_Info25 
    FOREIGN KEY (Product_Info_ID)
    REFERENCES t_Product_Info(Product_Info_ID)
;

ALTER TABLE t_Product_Sale_Info ADD CONSTRAINT Reft_Store_Info38 
    FOREIGN KEY (Store_ID)
    REFERENCES t_Store_Info(Store_ID)
;


-- 
-- TABLE: t_Shopping_Guide 
--

ALTER TABLE t_Shopping_Guide ADD CONSTRAINT Reft_Store_Info42 
    FOREIGN KEY (Store_ID)
    REFERENCES t_Store_Info(Store_ID)
;

ALTER TABLE t_Shopping_Guide ADD CONSTRAINT Reft_Company_Info41 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Sms_Send_History 
--

ALTER TABLE t_Sms_Send_History ADD CONSTRAINT Reft_Company_Info59 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


-- 
-- TABLE: t_Store_Info 
--

ALTER TABLE t_Store_Info ADD CONSTRAINT Reft_Company_Info34 
    FOREIGN KEY (Company_ID)
    REFERENCES t_Company_Info(Company_ID)
;


