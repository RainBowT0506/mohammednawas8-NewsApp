實作影片 [Jetpack Compose Clean Architecture News App](https://www.youtube.com/playlist?list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6)

Github [mohammednawas8-NewsApp](https://github.com/RainBowT0506/mohammednawas8-NewsApp)

# UI

OnBoardingScreen

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/7598a71a-4ddf-4a44-a28d-0f7452e6e454)


HomeScreen

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/944e6843-8e43-4962-8487-19cbd3ab70f5)


SearchScreen

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/7c336c11-01d6-4630-82d6-7dee6913917b)


ArticleDetail

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/e5877b64-2fe2-48d0-806f-3122b9727f6e)


ShareArticle

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/a517d608-897b-4705-a747-f96b0ddea8d5)


BookmarkScreen

![image](https://github.com/RainBowT0506/mohammednawas8-NewsApp/assets/109667537/8e6bb48b-2d01-47f1-afc3-27116833b9d3)


# Introduction
使用 Jetpack Compose 框架建立新聞應用程式。
## 主要功能:
1. 實作引導畫面，支援深/淺色模式。
2. 瀏覽新聞文章，顯示頂部標題新聞。
3. 進入文章詳細頁面，可點擊瀏覽器圖標閱讀完整文章，支援分享和收藏功能。
4. 搜尋功能，支援類別搜尋，顯示 shimmer 效果。
5. 保存文章功能，可在書籤頁面查看已保存文章。
## 教學內容:
1. 使用 Jetpack Compose 開發。
2. 採用清晰架構 (Clean Architecture)、MVVM 和 MVI。
3. 使用 Jetpack Paging3 處理新聞分頁載入。
4. 使用 Retrofit 進行網路請求。
5. 整合 Room Database 本地儲存文章。
6. 使用 DataStore Preferences 管理引導畫面的點擊事件。
7. 使用 Dagger Hilt 進行依賴注入。
## 前提條件:
1. 具備 Jetpack Compose 基礎。
2. 如果尚未學習 Jetpack Compose，建議先觀看作者的 Jetpack Compose 教學系列。
## 專案結構:
- 由於專案分為 12 部分，作者在 GitHub 上設置了 12 個不同的分支，方便觀眾查看特定部分的代碼。
- 初始專案在 master 分支。
## 專案設置步驟:
1. 從 GitHub 複製遠端專案連結。
2. 在 Android Studio 中選擇「File」->「New」->「Project from Version Control」。
3. 貼上遠端專案連結，點擊 Clone。
4. 設置 JDK 版本為 17。
5. 執行專案，確保下載成功。

# Splash Screen
## Splash Screen 主題設置
- 創建新的主題以實現 Splash Screen，透過進入 res/values，並創建一個名為 "Splash" 的主題。
- 新建一個名為 "AppStartingTheme" 的樣式，並設置其父主題為來自 Splash API library 的 "theme_splash_screen"。
- 在 Splash 主題中配置 Splash API，包括設置背景顏色和動畫圖標。
- 添加 "postSplashScreenTheme" 配置，以在顯示 Splash Screen 後應用主題。

## 適用於夜間模式的 Splash Screen
- 為了實現夜間模式的 Splash Screen，創建了具有 "night" 修飾符的相應主題。
- 在夜間模式版本中，複製了日間模式版本的主題設置，並修改了相應的顏色。

## Manifest 文件的配置
- 在 Manifest 文件中更新主題配置，將應用程序主題和活動主題更改為新創建的 "AppStartingTheme"。

## MainActivity 中的 Splash Screen 安裝
- 在 MainActivity 的 `onCreate` 函數中呼叫 `installSplashScreen` 以啟用 Splash Screen。

# Onboarding Page
## 建立 Presentation Package
- 創建 `presentation` package 作為 Clean Architecture 中的一部分，用於保存 UI 相關的代碼，包括屏幕、視圖模型等。

## 創建 Onboarding Package 與 Page Data Class
- 在 `presentation` package 中創建 `onboarding` package，用於保存與 Onboarding Screens 相關的代碼。
- 創建 `Page` 數據類，包含每個 Onboarding Screen 的標題、描述和圖片。

## 創建 Onboarding Page Composable Function
- 創建 `onBoardingPage` 的 Composable 函數，用於設計每個 Onboarding Screen 的 UI。
- 通過 `Pager` 和 `RememberPagerState` 實現横向滑動的 Onboarding Screens。
- 設計 Onboarding Screen 的標題、描述和圖片。

## 創建 Reusable Button Component
- 在 `presentation.common` package 中創建 `ReusableButton` 的 Composable 函數，實現可重用的按鈕 UI，接受文本和回調函數。

## 創建 Page Indicator Composable Function
- 在 `presentation.common` package 中創建 `PageIndicator` 的 Composable 函數，實現 Onboarding Screens 下方的頁面指示器。

## 設計 Onboarding Screen Composable Function
- 創建 `onBoardingScreen` 的 Composable 函數，設計包含 Onboarding Screens、Button 和 Page Indicator 的整體 UI。

# Onboarding Screen
## 完成 Onboarding Screen
- 在這個影片中，將完成 Onboarding Screen 的設計，並且確保在每個 Onboarding Screen 中添加了底部的指示器和按鈕區域。

## Spacer 與 Bottom Section
- 使用 `Spacer` 將底部的指示器和按鈕區域推到螢幕底部，使用 `weight` 屬性確保佔據適當的空間。
- 添加 `Spacer` 的主要目的是在 Onboarding Screen 與系統狀態欄（status bar）和導航欄（navigation bar）之間創建空間。

## Navigation Bar Padding
- 使用 `navigationBarsPadding` 來計算導航欄的高度，並將其作為 padding 添加到底部的 Row 中。
- 目的是確保整個 Onboarding Screen 的設計能夠適應系統狀態欄和導航欄，實現視覺上的一致性。

## Page Indicator
- 在設計中加入之前創建的 Page Indicator，以顯示用戶當前處於的 Onboarding Screen。
- 通過 `PagerState` 等參數配置 Page Indicator 的顯示。

## 按鈕邏輯
- 使用 Row 創建一個水平佈局，包含用於返回（back）的按鈕和用於進行下一步（next）的按鈕。
- 隱藏返回按鈕當用戶位於第一個 Onboarding Screen 時，以符合設計需求。

## 進行動作
- 通過按鈕的點擊來執行相應的動作，使用 `PagerState` 來實現 Onboarding Screen 的滑動。
- 處理最後一個 Onboarding Screen 的情況，可以進行應用程序的啟動或導向主屏幕。

## 處理 UI Behind System Bars
- 通過在 MainActivity 中使用 `WindowCompat` 並設置 `decorView.systemUiVisibility` 來確保 Onboarding Screen 在系統狀態欄和導航欄後方繪製。

## 主題與模式
- 考慮不同主題和模式下的外觀，確保 UI 在光亮模式和夜間模式下均呈現正確。

## 前瞻
- 未來將介紹一個更好的方法來改變狀態欄顏色，以提高代碼的可讀性和可維護性。 

# Preferences datastore
## Clean Architecture 簡介
![image](https://hackmd.io/_uploads/BJc4EIiKT.png)

- Clean Architecture 是一種結構專案的方式，旨在提高專案的可維護性和可擴展性。
- 可維護性表示當專案龐大時，修復錯誤或問題不至於讓開發者難以找到相應的代碼。
- 可擴展性表示能夠方便地新增功能，而不需修改現有的代碼。

## Clean Architecture 的三層結構
1. Data Layer
   - 存放與數據相關的所有內容，包括實現存儲偏好、數據庫、網絡等的代碼。
   - 提高測試性，可通過創建假存儲庫來測試數據層。

2. Domain Layer
   - 包含用例、數據模型和存儲庫接口。
   - 用例定義了應用程序的核心業務邏輯，數據模型表示數據結構，存儲庫接口用於定義與數據層的交互。

3. Presentation Layer
   - 包含與 UI 相關的所有內容，例如視圖、可組合的 UI、視圖模型和 UI 事件。
   - 大型圓圈能夠訪問小型圓圈，但反之則不行。

## Preferences Datastore 實現
- 使用 Jetpack Compose 中的 Preferences Datastore 實現本地存儲。
- 創建了 Data Layer 中的 `local user manager` 介面，定義了保存和讀取應用程序入口的功能。
- 在 Data Layer 中實現了這個介面的具體類，使用 Preferences Datastore 保存鍵值對，以及提供了對應的操作函數。

## Use Cases 實現
- 在 Domain Layer 中建立了 `use cases` 的包，用於保存和讀取應用程序入口。
- 這些 use cases 依賴於 `local user manager` 介面，這使得它們更易於測試，因為可以提供不同的介面實現。

## Dagger Hilt
- 在下一個視頻中，將實現 Dagger Hilt，這是一個用於 Android 應用程序的依賴注入框架，用於簡化代碼和提高可測試性。

---
# Dagger Hilt 
## Dagger Hilt 介紹
- Dagger Hilt 是一種用於 Android 應用程序的依賴注入框架，它可以方便地將依賴或對象注入到類中。
- 依賴注入的目的是將所需的依賴傳遞給類，例如在 Data Layer 中傳遞上下文（context）。

## Dagger Hilt 的設置步驟
1. Application Class 的創建
   - 創建了一個名為 `NewsApplication` 的應用程序類，繼承自 `Application`，並使用 `@HiltAndroidApp` 注解。

2. Module 的創建
   - 在 `di`（dependency injection）包下創建了一個名為 `AppModule` 的模塊。
   - 透過 `@Module` 和 `@Singleton` 注解，定義了模塊的生命週期為 Singleton。
   - 提供了 `LocalUserManager` 實現的依賴注入，以及 `ReadAppEntry` 和 `SaveAppEntry` 用例的依賴注入。

3. 依賴注入到 MainActivity
   - 在 `MainActivity` 中使用 `@Inject` 進行依賴注入，注入了 `AppEntryUseCases`。
   - 在 `launch` 區塊中使用了 `ReadAppEntry` 用例，並記錄了其值。

## 問題解決
- 在 MainActivity 中發現了一個問題，需要添加 `@AndroidEntryPoint` 注解以確保 Dagger Hilt 的正確運作。


# Onboarding ViewModel
## 實作 Onboarding ViewModel
- 影片開始處提到要實作 Onboarding ViewModel，這是為了處理 Onboarding Screen 中的邏輯，包括保存進入應用的事件。

## 創建 Onboarding ViewModel 類別
- 在 presentation 包下創建了 OnboardingViewModel 類別，這個類別是用來處理 Onboarding Screen 的邏輯，繼承自 ViewModel。
- 同時創建了一個 OnboardingEvent 類別，這是一個密封類別，表示可以從 UI 傳送到 ViewModel 的事件。目前只有一個事件，即保存應用進入事件。

## 使用 Dagger Hilt 進行依賴注入
- 在 OnboardingViewModel 中使用 Dagger Hilt 的 `@HiltViewModel` 進行依賴注入，注入了名為 `addIntroUseCase` 的 Use Case。

## 事件處理
- 在 OnboardingViewModel 中，僅暴露了一個公開函數 `onEvent` 用於處理從 UI 送來的事件，根據事件的不同進行相應的處理。
- 目前只處理了一種事件，即保存應用進入的事件。

## 儲存應用進入事件的邏輯
- 實作了 `saveAppEntry` 函數，使用了注入的 `addIntroUseCase` 進行應用進入事件的保存。
- 這個函數使用了 ViewModelScope，確保在 ViewModel 的生命週期中執行。

## 事件傳遞至 UI
- 在 Onboarding Screen 中，不再直接創建 ViewModel，而是透過接口回調的方式，將按鈕點擊事件傳遞至外部，這樣的設計是為了讓 Screen 更容易進行測試和預覽。
- 在 MainActivity 中使用 Hilt 的 `viewModel` 函數來獲取 OnboardingViewModel 實例，然後呼叫 `onEvent` 函數來傳遞按鈕點擊事件。

## 透過 LiveData 觀察 Use Case 的執行結果
- 在 MainActivity 中，使用協程觀察 `addIntroUseCase` 的執行結果，並將結果輸出至 Log 中，以驗證是否成功保存了應用進入事件。

## 測試結果
- 測試結果顯示一開始為 false，表示應用進入事件尚未保存。在點擊 "Get Started" 後，成功保存了應用進入事件，Log 中輸出了 true。

# Navgraph 
## 設置導航圖和導航系統
- 在 Presentation Layer 中建立 `net.grab` 包，並創建一個 `Route` 類來定義不同屏幕的路徑。
- 使用密封類 `Route`，其中包含不同屏幕的對象。
- 創建導航圖 `NavGraph`，設置導航控制器和起始目的地。

## 定義路徑和屏幕
- 使用封裝類 `Route`，定義了不同屏幕的路徑和子導航圖。
- 創建了導航系統的各種屏幕，如 `OnBoardingScreen`、`HomeScreen`、`SearchScreen` 等。
- 為每個屏幕創建對應的路徑對象，並將其分類為主導航或子導航。

## 創建導航系統
- 在 `NavGraph` 中創建導航宿主，並添加子導航圖以實現不同屏幕的導航。
- 使用 `NavHost` 和導航控制器來設置起始目的地和導航行為。
- 使用 `navigation` 函數來設置主導航和子導航的起始目的地。

## 實現動態導航
- 使用 View Model 中的數據來動態決定起始目的地。
- 使用 `readAppEntry` Use Case 來讀取應用程序的進入點設置。
- 根據應用程序的狀態，將起始目的地設置為主導航或子導航中的一個。

## 管理啟動畫面
- 使用 Splash 條件來控制啟動畫面的顯示時間。
- 通過持續收集應用程序的進入點來確保啟動畫面的正確顯示。
- 使用 ViewModel 和 Composable 函數來動態設置起始目的地和啟動畫面的顯示。
 
# System UI Controller
## 使用 System UI Controller 更改系統 UI 顏色
- 在 `MainActivity` 中，使用 System UI Controller 库來更改狀態欄和導航欄的顏色。
- 創建一個 `isSystemInDarkMode` 的 Composable 函數來檢查系統是否處於深色模式。
- 使用 `rememberSystemUiController` 獲取 System UI Controller 的實例。

## 設置狀態欄和導航欄顏色
- 在 `sideEffect` 區塊中，使用 `systemController.setSystemBarColors` 來設置系統欄的顏色。
- 將狀態欄顏色設置為 `color.transparent` 以實現透明效果，並根據深色模式使用負的顏色值設置深色圖標。
- 去除 `values` 中之前添加的項目以確保透明系統欄正常顯示。

## 測試透明系統欄效果
- 啟動應用程序後，應該能夠看到透明的系統欄，既不帶顏色也不帶圖標。
- 可以在 `sideEffect` 區塊中更改深色圖標的顏色，並演示不同的效果。

## 額外補充
- System UI Controller 库提供了 Compose 中操作系統 UI 的功能，例如更改狀態欄和導航欄顏色。
- 透明的系統欄可實現將 UI 延伸到狀態欄和導航欄下面，提供更流暢的使用者體驗。
 

# Home Screen Get News
## 設定 API Key 和 Endpoints
- 在此視頻中，作者介紹了使用 [News API](https://newsapi.org/) 來獲取新聞數據，並指導觀眾獲取 API Key 的步驟。
- 使用 News API 提供的 `everything` 端點，作者示範了 API 響應的例子，並在 Kotlin 中創建了對應的數據類 `NewsResponse`。

## 創建 Remote Package 和 DTO
- 在 Android Studio 中，作者創建了一個 `remote` 包，並在其中創建了一個 DTO（Data Transfer Object）包，以放置 API 響應的類。
- 使用 [JSON to Kotlin Class 插件](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-)，作者將 API 響應轉換為 Kotlin 類，並進行了相應的整理和移動。

## 使用 Retrofit 創建 News API
- 在 `remote` 包中，作者創建了一個 `NewsAPI` 介面，使用 Retrofit 來定義 API 請求。
- 定義了一個 `getNews` 函數，並指定了所需的參數，包括頁碼、新聞源和 API Key。

## 實現 Paging 3 Library
- 在 `domain` 包中的 `repository` 包裡，作者創建了一個 `NewsRepository` 介面，並定義了一個 `getNews` 函數，返回使用 Paging 3 Library 封裝的 `Flow<PagingData<Article>>`。
- 在 `remote` 包中，創建了一個 `NewsPagingSource` 類，實現了 `PagingSource` 介面，並使用 News API 進行分頁請求。
- 在 `data` 包中，實現了 `NewsRepositoryImpl` 類，實現了 `NewsRepository` 介面，並使用 `Pager` 和 `NewsPagingSource` 進行分頁加載。

## 創建 Use Case
- 在 `domain` 包中，作者創建了一個 `usecase` 包，並在其中創建了一個 `GetNewsUseCase` 類，作為使用案例。
- 使用案例中實現了一個 `invoke` 運算符，調用 `NewsRepository` 的 `getNews` 函數，返回分頁數據。

# Home Screen ViewModel
## 創建 Home ViewModel
- 在這段視頻中，作者建立了 Home 界面的 ViewModel，這是一個與界面相關的組件，負責處理界面的邏輯和數據。
- 在 `presentation` 層的 `home` 包中，作者創建了一個名為 `HomeViewModel` 的類，並使其擴展自 `ViewModel`。
- 使用了 `hiltViewModel` 注解，這是 Dagger Hilt 框架提供的用於構建 ViewModel 的注解，並注入了 `NewsUseCases` 這一用例類。

## 創建 NewsUseCases 並注入依賴
- 為了提供 ViewModel 所需的 `NewsUseCases`，作者創建了一個 `NewsUseCases` 的數據類，其中包含了 `GetNewsUseCase`。
- 使用 Dagger Hilt 的 DI（依賴注入）功能，在 DI 模塊中提供 `NewsUseCases`，`NewsRepository` 以及 `NewsAPI`。
- 通過 `hiltViewModel` 注解，在 `HomeViewModel` 中注入 `NewsUseCases` 依賴。

## 實現 HomeViewModel 的基本邏輯
- 在 `HomeViewModel` 中，作者定義了一個 `news` 的成員變量，用於保存從 API 獲取的新聞數據。
- 使用 `cachedIn(viewModelScope)` 方法來確保數據在配置更改時不會丟失，並將其緩存在 ViewModel 的作用域內。
- 調用 `newsUseCases.getNews` 函數，並傳遞新聞來源（source），以獲取新聞數據。

## 創建 ArticleCard Composable
- 在 `presentation.common` 包中，作者創建了一個名為 `ArticleCard` 的 composable 函數，用於顯示新聞卡片。
- 使用 `AsyncImage` 來加載新聞圖片，並設置樣式和排版。
- 將新聞的標題、來源、發布時間等信息嵌入到 composable 中，並使用 Material Design 的風格進行設計。

## 創建 Shimmer Effect Composable
- 在 `presentation.common` 包中，作者創建了一個名為 `ShimmerEffect` 的 composable 函數，用於實現 Shimmer 效果。
- 使用自定義的 `modifier` 和 `Transition` 對背景顏色的 alpha 值進行動畫過渡，創建出閃爍的效果。
- 這個 Shimmer 效果可以應用在任何需要加載時顯示的地方。 

# Finish Home Screen
## Articles List Composable
- 建立 `ArticlesList` Composable，用於顯示從 Pedium 3 獲取的文章列表。
- 放置於 `common` 封裝中，因它將在不同畫面上重複使用。
- 參數包括 `modifier`、`Articles`、以及 `onItemClick`。
- 引入 `Shimmer` 效果，以處理資料載入中的視覺呈現。

## Handle Paging Result Function
- 創建 `handlePagingResult` 函數，用於處理分頁加載的狀態。
- 返回布林值，表示是否成功獲取文章。
- 利用 `loadState` 來處理載入狀態及錯誤處理。
- 針對不同的錯誤，返回相應的錯誤信息。

## Home Screen Composable
- 建立 `HomeScreen` Composable，用於顯示主畫面。
- 包含搜尋條、新聞標題、文章列表等元素。
- 使用 `LazyPagingItems` 來顯示文章列表，透過 `ViewModel` 取得文章數據。
- 實現搜尋條的點擊事件，導航至搜尋畫面。
- 新聞標題部分使用 `BasicMarquee` 實現水平跑馬燈效果。

## Search Bar Composable
- 創建 `SearchBar` Composable，用於顯示搜尋條。
- 利用 `InteractionSource` 獲取搜尋條點擊事件，進行導航。
- 以自定義的邊框樣式區分深色和淺色主題。

## 修復問題
- 修正搜尋條的水平填充問題，增加適當的水平填充。
- 修正文章卡片中圖片的顯示問題，確保圖片充滿容器。


# Search Screen
#### 搜索功能的實現
- 在這一部分，開發者介紹了如何在應用程式中實現搜索功能。
- 通過在數據層的 News API 中實現一個新的搜尋端點，使用 `suspend` 函數 `searchNews`，該函數接受搜索查詢（`searchQuery`）作為參數，並返回 `newsResponse`。
- 開發者提到使用與獲取新聞的端點相同的端點，但這次用於搜索。

#### 構建 Search News Paging Source
- 在遠程包中，建立了一個 `SearchNewsPagingSource` 類，類似於之前建立的 `NewsPagingSource`。
- 這個 `SearchNewsPagingSource` 需要 API、搜索查詢和源作為參數，並且擴展了 `PagingSource`。
- 在 `SearchNewsPagingSource` 中，開發者重寫了 `getRefreshKey` 和 `load` 函數，以實現搜索新聞的相關邏輯。

#### 在 Repository 中實現搜索新聞的功能
- 在領域層的 Repository 中，開發者新增了一個函數 `searchNews`，該函數接受搜索查詢作為參數，調用了之前實現的 `SearchNewsPagingSource`。
- 當然，這個函數最終返回了獲取的新聞數據。

#### 前端 ViewModel 與 State 的設計
- 在前端 ViewModel 中，新增了一個 `SearchViewModel` 類，並使用 Hilt ViewModel 進行初始化。
- 引入了新的 `SearchNews` use case 用於搜索新聞，同時在 Repository 中注入了這一新的 use case。

#### 設計 Search Screen
- 在演示層的搜索包（presentation layer）中，創建了一個名為 `SearchScreen` 的類，該類負責展示搜索相關的 UI。
- 使用 `SearchState` 類來管理搜索查詢和新聞列表的狀態。
- 介紹了一個名為 `SearchEvent` 的事件類，用於更新搜索查詢和觸發搜索新聞的動作。
- 詳細描述了 UI 中的搜索欄位、搜尋按鈕、以及顯示新聞列表的部分。

# Details Screen
#### 製作 Details Top Bar
- 在這一部分，開發者創建了一個名為 `DetailsTopBar` 的 composable function，主要包含了導航按鈕和三個選項：書籤、分享和瀏覽。
- 使用 `TopAppBar` 作為基本框架，並加入了相應的按鈕和事件處理。
- 引入 `Painter`、`ImageVector` 和 `colorResource` 來設計圖標和顏色。

#### 實現 Detail Screen
- 在 `presentation` 層的 `details` package 中，創建了一個名為 `DetailsScreen` 的 composable function。
- 接受文章 `article` 和事件 `event` 作為參數，展示了詳細內容的 UI。
- 使用 `LazyColumn` 使畫面可滾動，其中包含了文章的圖片、標題和內容。

#### 實現 Browsing、分享和書籤功能
- 在 `DetailsScreen` 中，實現了點擊瀏覽、分享和書籤的相應功能。
- 使用 `Intent` 來啟動瀏覽功能，透過隱式意圖指定 `action` 為 `ACTION_VIEW`，並檢查是否有應用程序可以處理此操作。
- 分享功能使用 `ACTION_SEND` 的隱式意圖，並將文章的 URL 作為文本內容。
- 書籤功能則透過事件 `DetailsEvent` 傳遞至 ViewModel 進行處理，同時觸發返回上一層的操作。

#### 修復 UI 錯誤
- 在預覽功能中，發現了一個 UI 錯誤，已經進行了修復，確保分享按鈕正確顯示。 
 
# Room Database
#### 實作 Room Database
- 在這一部分，開發者開始實作 Room Database，目的是能夠在本地數據庫中保存新聞文章。
- 開始於 `data` 層創建名為 `local` 的新 package，這是用來存放與本地數據庫相關的類別和介面。
- 首要步驟是定義數據表（table），在 `domain` 層的 `model` 中的 `Article` 類別上使用 `@Entity` 標註，這將被轉換為 Room Database 中的數據表。

#### 實現 DAO（Data Access Object）
- 在 `local` package 中，創建了 `NewsDao` 接口，它是 DAO（Data Access Object）的實現，負責訪問數據庫並執行各種操作，如插入、更新、刪除等。
- 使用 `@Dao` 標註，這樣 Room 就能夠生成實現這個接口的實例。
- 實現了插入（`upsert`）、刪除和獲取文章的相應方法。

#### 實現 Type Converter
- 為了將 `Source` 這個自定義的類型存儲到數據庫中，開發者實現了一個 Type Converter，將 `Source` 轉換為字符串以及將字符串轉換回 `Source`。
- 使用 `@TypeConverter` 標註，並實現兩個相應的轉換方法。

#### 創建 Room Database
- 在 `NewsDatabase` 類別中，擴展了 `RoomDatabase` 並使用 `@Database` 標註，配置數據庫的相關信息，包括數據表和版本號。
- 添加了 Type Converters 的標註，以便 Room 知道如何處理自定義類型。
- 使用 Dagger Hilt 在 DI 中提供 `NewsDao` 的實例。

#### 整合到應用程式
- 在 `MainActivity` 中，透過 Dagger Hilt 注入 `NewsDao`，並進行數據庫的操作，插入一條虛構的文章數據。
- 經過檢查，確保數據成功存儲到 Room Database 中。
![CleanShot 2024-03-07 at 14.15.14](https://hackmd.io/_uploads/Hkm9o0LaT.png)

# Bookmark Screen
#### 創建 Bookmark Screen
- 在這一部分，開發者開始建立書籤（Bookmark）畫面，該畫面將顯示保存的文章列表。這是系列中的最後一個畫面，並且開發者計劃在下一個視頻中完成整個播放列表的實現。
- 一開始，進入 `presentation` 層，創建一個新的 `bookmark` package。然後創建 `BookmarkViewModel` 以及相關的用例（use cases），這些用例將與數據層進行交互。

#### 實作 BookmarkViewModel
- 在 `BookmarkViewModel` 中，開發者創建了三個用例：
  1. upsertArticle: 用於插入或更新文章。
  2. deleteArticle: 用於刪除文章。
  3. selectArticles: 用於選擇或檢索文章列表。
- 這些用例與 `NewsDao` 進行交互，並在 `BookmarkViewModel` 中進行調用。

#### 實作 Bookmark Screen
- 創建 `BookmarkScreen`，使用 Compose 構建 UI。在這個畫面中，首先設置了畫面的基本結構，包括標題和相關的樣式設置。
- 使用 `ArticlesList` 組件顯示保存的文章列表，同時實現了點擊文章後導航到詳細信息畫面的功能。
- 在 `BookmarkScreen` 中，還有一個私有方法 `getArticles`，用於從數據層獲取文章列表並更新 UI。
- 透過 `BookmarkViewModel` 獲取數據，並在 UI 中顯示。

 
---
# News Navigator
### 1. 重點整理與補充

#### 創建 Details Screen 及 Details ViewModel
- 開發者在這一部分建立了 Details Screen，同時創建了 Details ViewModel 並擴展了 FrontViewModel 和 HealthViewModel。
- 在 Details ViewModel 中，引入了一個稱為 "side effect" 的可變狀態，用於處理在 Details Screen 中的事件，並使用 Nullable String 來表示目前的 side effect。
- 創建了兩個事件：upsert/delete article 和 remove side effect。這些事件與 News Use Cases（新聞用例）進行交互，實現對文章的插入、更新、刪除以及處理 side effect。

#### 實現 Bottom Navigation 和 News Navigator Screen
- 創建了 News Bottom Navigation，使用 Compose 實現底部導航欄，允許切換不同的屏幕。
- 在 News Navigator Screen 中，使用 Scaffold（組成 UI 的一個材料風格組件）設置應用的基本結構，包括頂部工具欄和底部導航欄。同時創建了不同的 Composable 函數來顯示不同的屏幕。

#### 管理 Bottom Navigation 的顯示狀態
- 引入了 Bottom Navigation 的顯示狀態，使用 remember 和 back stack state 來控制 Bottom Navigation 的顯示與隱藏。
- 當處於 Home、Search 或 Bookmark Screen 時，顯示 Bottom Navigation，否則隱藏。這是通過 back stack state 來實現的。

#### 處理 Details Screen 中的 Side Effect
- 在 Details Screen 中，當觸發事件時，使用 Side Effect 通知用戶有相應的操作發生。同時，該 Side Effect 會在顯示後被移除，以確保下次操作不會重複通知。

#### 修改 Bookmark 列表的顯示順序
- 在執行中發現 Bookmark 列表顯示順序需要反轉。這是通過在 Bookmark ViewModel 中對列表進行反轉來實現的。
- 使用 on each 和 reverse 方法，確保在 UI 中顯示的順序是反轉的，達到期望的效果。
 
# 專業術語
- Splash Screen: 一種在應用程序啟動時顯示的短暫界面，用於提供品牌標誌或應用程序入口。在這裡，使用 Splash API library 實現了 Splash Screen。
- Theme: 定義應用程序的外觀和風格的一組風格和資源配置。在這裡，創建了日間和夜間模式下的 Splash Screen 主題。
- Night Mode: 夜間模式是應用程序的一種顯示模式，通常使用較暗的顏色和低亮度，以減少對用戶眼睛的刺激。在這裡，實現了夜間模式的 Splash Screen。
- Manifest File: Android 應用程序的清單文件，包含應用程序的配置信息，例如主題、活動和權限等。
- installSplashScreen: 一個函數，用於啟用 Splash Screen。在這裡，於 MainActivity 中的 `onCreate` 函數中呼叫了該函數。
- Post Splash Screen Theme: Splash Screen 顯示後應用的主題配置。在這裡，配置了在 Splash Screen 後應用的主題。
- Experimental Foundation Api
- Clean Architecture: 一種結構專案的方法，旨在提高可維護性、可擴展性，並使專案更易測試。它將專案分為三層：Data Layer、Domain Layer、Presentation Layer。
- Data Layer: 存放與數據相關的代碼，包括實現存儲偏好、數據庫、網絡等的內容。提高測試性，可通過創建假存儲庫測試數據層。
- Domain Layer: 包含用例、數據模型和存儲庫接口。用例定義了核心業務邏輯，數據模型表示數據結構，存儲庫接口定義與數據層的交互。
- Presentation Layer: 包含與 UI 相關的代碼，例如視圖、可組合的 UI、視圖模型和 UI 事件。具有對 Data Layer 和 Domain Layer 的訪問權限。
- Preferences Datastore: Jetpack Compose 中的一種工具，用於實現本地存儲。用來保存鍵值對，提供了方便的 API 來處理應用程序的配置數據。
- Use Cases: 在 Domain Layer 中的包，包含了定義應用程序功能的高級業務邏輯。這裡特指保存和讀取應用程序入口的 use cases。
- Dagger Hilt: 一個用於 Android 應用程序的依賴注入框架。用於簡化代碼、提高可測試性，並使代碼更容易理解和維護。
- Dagger Hilt: 一個用於 Android 應用程序的依賴注入框架。通過注入依賴或對象，使代碼更容易理解、測試和維護。
- Dependency Injection (DI): 一種軟體設計模式，其中一個類的依賴關係由外部注入，而不是在類內部創建。這有助於降低類之間的耦合性。
- Application Class: Android 應用程序中的一個類，用於管理應用程序的全局狀態。在這裡，創建了 `NewsApplication` 並用於 Dagger Hilt 的設置。
- Module: Dagger Hilt 中的概念，表示一個模組，其中定義了依賴的提供方式。在這裡，`AppModule` 定義了需要提供的依賴。
- Singleton: 一種生命週期，表示只有一個實例存在。在 Dagger Hilt 中，使用 `@Singleton` 標記模組，使其生命週期為 Singleton。
- @Inject: Dagger Hilt 中的注解，用於標記需要進行依賴注入的構造函數或屬性。
- @HiltAndroidApp: Dagger Hilt 中的注解，用於標記應用程序的 `Application` 類，以進行 Dagger Hilt 的初始化。
- AndroidEntryPoint: Dagger Hilt 中的注解，用於標記 Android 組件，以通知 Dagger Hilt 將依賴注入到該組件中。在這裡，用於 `MainActivity`。
- Pager: 一種用於實現橫向或縱向滑動效果的 Jetpack Compose 組件，用於顯示多個屏幕或頁面。
- RememberPagerState: 一個 Jetpack Compose 中的 State，用於保持 Pager 的狀態，例如當前頁面索引。
- Composable Function: Jetpack Compose 中的一種函數，用於定義 UI 元素的可組合組件。
- Reusable Component: 可重用的 UI 元素或組件，可以在應用程序的不同部分或不同屏幕中使用。
- Page Indicator: 用於指示當前頁面的 UI 元素，通常是一組小圓點或其他符號。
- Clean Architecture: 一種軟件架構模式，強調將應用程序代碼分為不同的層次，例如 Presentation、Domain、Data 等，以實現可維護性和可擴展性。
- Drawable Resource: 在 Android 開發中，用於存儲圖像等可繪內容的資源。
- State: 在 Jetpack Compose 中，用於表示 UI 的可變數據，當數據更改時，UI 會自動刷新。
- Modifier: 在 Jetpack Compose 中，用於修改或應用樣式的屬性，例如大小、位置、填充等。
- Spacer: 用於在 Jetpack Compose 中創建空白區域，調整元素之間的間距。
- Typography: 與文本風格和字體相關的概念，在 Jetpack Compose 中用於定義文本的外觀。
- Preview Function: 用於在開發過程中快速預覽 Compose 函數的效果，以方便調試和設計。
- Background Color: UI 元素的背景色，通常根據 Material Theme 或自定義配置。
- UI Components: 構成應用程序用戶界面的基本元素，例如按鈕、文本、圖片等。
- Content Description: 在 Android 開發中，用於描述 UI 元素的輔助功能文本，通常用於可訪問性。
- Circular Shape: 表示 UI 元素的圓形形狀。
- Jetpack Compose Theme: 用於定義應用程序外觀的配置，包括顏色、字體等。
- Light Theme / Night Mode: 應用程序的不同外觀模式，分別適應亮度和暗度環境。
- Clip: 在 Compose 中，用於將 UI 元素裁剪為指定形狀或大小的操作。
- Modifier: 在 Compose 中，用於修改或定義 UI 元素的屬性。
- Primary Color: 在 Material Theme 中，表示應用程序主要顏色，通常是突出顯示的顏色。
- Reproducible Bug: 可以在開發環境中再現的錯誤，有助於開發人員進行調試和修復。
- Jetpack Compose Split: 用於在開發中實時查看 Compose UI 效果的工具。
- Horizontal Pager: 在 Jetpack Compose 中，實現橫向滑動效果的 Pager 組件。
- 引導畫面 (Onboarding Screens): 第一次啟動應用程式時，向用戶顯示的介紹性畫面，通常包含教育性內容和功能介紹。
- Clean Architecture: 軟體設計架構的一種方法，強調將代碼分為不同的層次 (如表示層、業務邏輯層、數據層) 以實現模組化和可維護性。
- Composable: 在 Jetpack Compose 中的 UI 元素，是以函數的形式構建並支援組合式 UI 開發。
- DataStore Preferences: Android 中的數據存儲庫，用於存儲應用程式的配置和簡單的鍵值對數據。
- PagerState: 在 Jetpack Compose 中用於管理分頁的狀態的類。
- rememberPagerState: Jetpack Compose 中的鉤子，用於保留分頁狀態。
- remember: Jetpack Compose 中的鉤子，用於保存可變數據，以便在重新構建期間保留其值。
- deriveStateOf: 由 `remember` 提供的鉤子，用於計算狀態的衍生狀態，以實現更複雜的邏輯。
- 水平分頁 (Horizontal Pager): 在 Compose 中用於支援水平滑動並顯示多個項目的 UI 元素。
- Material Theme: Android 中的 UI 設計樣式，提供預先定義的顏色、樣式和元件。
- Spacer: 在 Compose 中用於創建空白區域的元素，通常用於調整元素之間的間距。
- Navigation Bar Padding: 用於計算導航欄高度的 Modifier，確保 UI 在導航欄的存在下有適當的空間。
- Page Indicator: 顯示當前頁面的 UI 元素，通常是一組小圓點或其他符號，用於引導用戶的位置。
- PagerState: 在 Jetpack Compose 中用於跟踪 Pager 的狀態，例如當前頁面索引。
- System Bars: 在 Android 中指系統狀態欄（status bar）和導航欄（navigation bar）的組合。
- WindowCompat: 用於支持不同 Android 版本中 Window 的兼容性工具。
- Light Mode / Night Mode: 應用程序的不同主題模式，分別適應亮度和暗度環境。
- UI Behind System Bars: 確保 UI 元素能夠在系統狀態欄和導航欄的後方正確顯示。
- Animate Scroll To Page: 使用 `PagerState` 中的 `animateScrollToPage` 函數實現平滑的頁面滾動效果。
- DecorView: 在 Android 中表示 Activity 的根 View，通常用於操作整個 Activity 的 UI。
- SystemUiVisibility: 用於設置 DecorView 的系統 UI 的可見性，例如隱藏或顯示狀態欄和導航欄。
- Theme and Mode Handling: 確保應用程序能夠在不同的主題和模式下呈現一致的外觀。
- CoroutineScope.launch: 使用 Kotlin 協程啟動一個新的協程，處理非同步任務。
- DataStore Preferences: 將用戶的操作（例如點擊 "Get Started"）保存在本地，通常使用 DataStore 實現。
- Jetpack Compose Split: 用於實時查看 Compose UI 效果的工具，通常在開發過程中使用。
- Named Attribute: 在 Compose 中，指定屬性的方式，通常用於提高可讀性和代碼的清晰性。
- Spacer: 在 Compose 中用於添加間距和區隔 UI 元素的組合元素。
- Row: Compose 中的元素，用於水平排列子元素。
- Column: Compose 中的元素，用於垂直排列子元素。
- PagerState: 在 Jetpack Compose 中用於處理分頁和滑動的狀態的類。
- animateScrollToPage: PagerState 中的函數，用於平滑滑動到指定頁面。
- rememberCoroutineScope: Compose 中的鉤子，用於獲取協程範圍，以便進行異步操作。
- launch: 協程範圍的函數，用於啟動異步任務。
- WindowCompat: Android 中的支援庫，用於處理窗口相關的設置，如系統欄的顯示。
- setDecorFitsSystemWindows: 設置是否將畫面延伸到系統欄後面。
- windowTranslucentStatus 和 windowTranslucentNavigation: 設置系統欄是否半透明的屬性。
- ViewModel: 在 Android 架構組件中，用於管理 UI 相關數據以及處理 UI 邏輯的類別。ViewModel 被設計為能夠存儲和管理 UI 相關數據，並且在配置更改（如屏幕旋轉）時保持數據的狀態。
- Dagger Hilt: 一個用於 Android 應用程式的依賴注入框架，它簡化了 Dagger 2 的使用，並提供更容易的配置和集成。
- Use Case: 在軟體開發中，一個用於執行特定任務或功能的獨立模塊。在這裡，`addIntroUseCase` 可能是一個用於處理應用進入事件的 Use Case。
- CoroutineScope: 用於啟動 Kotlin 協程的界面，確保協程在特定的生命週期內運行。在這裡，使用了 ViewModelScope 來確保 `saveAppEntry` 函數在 ViewModel 的生命週期內執行。
- LiveData: 在 Android 中用於在數據更改時通知觀察者的一個可觀察的數據持有者。在這裡，可能使用 LiveData 來觀察 Use Case 的執行結果，並在 UI 中進行相應的更新。
- Log: 在 Android 開發中，用於輸出調試信息的一種機制，通常使用 `Log.d` 或其他相關方法來輸出訊息。
- Coroutine: 在 Kotlin 中提供的異步編程框架，用於處理非同步任務，避免阻塞主線程。在這裡，使用了協程來執行非同步的 Use Case。
- Hilt ViewModel: Dagger Hilt 中用於注入 ViewModel 的擴展，簡化了 ViewModel 的依賴注入。
- Sealed Class: 一個用於表示有限集合類型的 Kotlin 類別。在這裡，`OnboardingEvent` 是一個密封類別，用於表示可能從 UI 傳送到 ViewModel 的事件。
- 導航圖（NavGraph）：在 Jetpack Compose 中用於定義應用程序的導航結構的組件。
- 導航控制器（NavController）：在 Android 中用於管理應用程序導航的組件，可用於在不同屏幕之間進行導航。
- 應用程序進入點（App Entry Point）：應用程序的起始點，可以是引導屏幕、主屏幕或其他任何應用程序的入口。
- 封裝類（Sealed Class）：在 Kotlin 中用於表示受限的類型層級集合，通常用於表示固定數量的可能類型。
- View Model：在 Android 中用於管理 UI 相關數據並在配置更改時保存狀態的組件。
- System UI Controller：Compose 中的庫，用於操作 Android 系統 UI，例如調整狀態欄和導航欄的外觀。
- Composable 函數：Compose 框架中的函數，用於定義 UI 的可組合元素。
- `rememberSystemUiController`：Compose 中的功能，用於獲取 System UI Controller 的實例，以便在 Composable 函數中使用。
- `sideEffect`：Compose 中的區塊，用於執行在成功重新組合時觸發的副作用代碼。
- 透明效果：通過將顏色設置為 `color.transparent`，使系統欄變為透明，允許 UI 在其下方顯示，提供更清晰的畫面。
- API Key：用於識別和授權 API 請求的密鑰，確保僅授權的用戶能夠訪問 API。
- Endpoints：API 提供的不同端點，每個端點都代表一個特定的功能或數據集。
- Data Transfer Object (DTO)：用於在不同層之間傳輸數據的對象，通常用於將 API 響應轉換為應用程序中使用的數據類。
- Retrofit：Android 上用於進行簡化的 HTTP 請求的庫，用於與 Web 服務進行通信。
- Paging 3 Library：Android Architecture Components 中的庫，用於實現列表分頁和異步數據加載，提高性能和效率。
- Paging Source：Paging 3 Library 中的一個抽象類，用於定義如何從數據源（如 API 或數據庫）中加載數據。
- Use Case：在軟體開發中，表示應用程序執行的某一功能或操作的獨立單元，有助於保持代碼的模塊化和可測試性。
- ViewModel：一種 Android Architecture Components，用於以可感知生命周期的方式管理和存儲與 UI 相關的數據。
- Dagger Hilt：一個 Android 中用於依賴注入的框架，簡化了構建應用程序的過程，並提高了代碼的可測試性。
- DI (依賴注入)：一種設計模式，用於實現類與其依賴之間的解耦，通過注入依賴實現對象的創建和管理。
- hiltViewModel：Dagger Hilt 框架提供的一個注解，用於構建 ViewModel，並透過 DI 注入相應的依賴。
- Coroutine ViewModel Scope：ViewModel 的作用域，用於在 ViewModel 的生命周期中運行協程，確保當 ViewModel 存在時協程能夠運行。
- AsyncImage：Coil 库提供的一個 composable 函數，用於異步加載圖片，支持在 Compose 中使用協程。
- Shimmer Effect：一種 UI 效果，通常用於指示數據正在加載中。在這裡，通過改變背景顏色的 alpha 值實現閃爍效果。
- Jetpack Compose: 一個由 Android 提供的現代 UI 工具包，使用 Kotlin 語言構建 UI 界面。
- Composable: 在 Jetpack Compose 中，表示一個可以構建 UI 元素的函數或元件。
- Lazy Paging Items: 一種用於分頁顯示數據的組件，當需要顯示大量數據時，只載入當前可見的部分，提高性能。
- Shimmer Effect: 一種用於指示數據載入中的視覺效果，常用於顯示虛擬的光影。
- ViewModel: 用於管理並保存 UI 相關數據的 Android 架構元件。
- Basic Marquee: Jetpack Compose 中的實驗性特性，提供簡單的水平跑馬燈效果。
- Interaction Source: 提供 UI 事件的源頭，用於捕捉和處理使用者的交互動作。
- Derived State of: 用於基於其他狀態計算新的狀態，確保 UI 保持同步。
- Content Scale: 用於指定圖片在容器中的縮放方式，例如 Crop 表示裁剪填滿。
- Marquee: 一種文本或圖片在界面上水平滾動的效果。
- Manifest File: Android 應用的清單文件，包含應用的配置和權限等信息。
- Search News Paging Source: 用於實現搜索功能的分頁數據源，擴展自 Android Jetpack 中的 `PagingSource`，處理新聞搜索的請求和分頁數據加載。
- Use Case: 在軟體開發中，代表一個特定的用例或功能，通常是一個業務邏輯操作的抽象層，將 UI 和數據層分開。
- Hilt ViewModel: 使用 Hilt 框架進行依賴注入的 ViewModel，使得 ViewModel 的實例可以被自動管理和注入相依的組件。
- MutableState: 一種 Kotlin 中的數據類型，代表一個可變的狀態，可以通知觀察者當數據發生變化。
- PagingSource: Android Jetpack 中用於實現分頁加載的抽象類型，管理數據的分頁載入和緩存。
- ViewModel Scope: 用於確保 ViewModel 中的操作在特定生命周期內運行的區域，避免內存泄漏和意外的生命週期問題。
- Composable Function: Jetpack Compose 中的概念，表示一個可組合的 UI 元素，用於構建應用程序的界面。
- TopAppBar: Jetpack Compose 中的一種 UI 元素，用於在頂部顯示應用程序的標題欄，通常包含導航按鈕和操作按鈕。
- LazyColumn: Jetpack Compose 中的組合元素，用於顯示可滾動的垂直列，僅在需要時才加載和顯示可見的項目，用於提高性能。
- Intent: 在 Android 中，用於在應用程序之間執行操作的對象，可以啟動活動、服務或廣播接收器。
- 隱式 Intent: 指定操作，但不指定要執行該操作的確切組件，由系統選擇最合適的組件。
- ViewModel: Android 架構組件，用於存儲和管理 UI 相關的數據，並在配置更改時保持數據的一致性。
- Painter: Compose 中用於繪製可縮放的矢量圖形的類型。
- ImageVector: 表示可縮放的矢量圖形，通常用於顯示圖標和圖片。
- MutableState: Jetpack Compose 中的數據類型，表示一個可變的狀態，當數據發生變化時會通知觀察者。
- Implicit Intent: 由系統選擇要執行的組件的 Intent，不指定確切的組件。
- URI: 統一資源標誌符，用於標識和定位網路上的資源，如網頁或文件。
- ViewModel Scope: 用於確保 ViewModel 中的操作在特定生命周期內運行的區域，防止內存泄漏和生命周期問題。
- Room Database: Android 中的一個持久性數據庫解決方案，基於 SQLite，提供了一個用於數據訪問和操作的抽象層。
- DAO (Data Access Object): 用於定義數據庫操作的介面或類別，通常包括插入、更新、刪除和查詢等方法。
- Entity: 在 Room Database 中，表示映射到數據庫表的 Java/Kotlin 對象的類別。
- Type Converter: 用於將非標準數據類型轉換為 Room Database 可以處理的基本數據類型的工具，通常用於自定義類型的處理。
- Dagger Hilt: 一個 Android 平台上的依賴注入框架，用於管理應用程序中的對象和其相依關係。
- DI (Dependency Injection): 一種軟體設計模式，通過將對象的創建和相依關係的管理交給外部系統，以實現松散耦合和更好的可測試性。
- LiveData: Android 架構組件，用於在數據發生變化時通知觀察者，特別適用於構建反應性 UI。
- Coroutines: Kotlin 語言的非同步編程框架，用於更簡潔和可讀的非阻塞程式碼撰寫。
- Bookmark Screen: 指書籤畫面，用於顯示已保存文章的列表。
- ViewModel: 在 Android 中，用於處理 UI 相關數據和業務邏輯的組件，有助於確保 UI 組件的獨立性。
- Use Cases: 代表應用程序中的一個功能，包含了相關的業務邏輯。在這裡，用於處理與數據庫的交互操作。
- Lazy Column: 在 Jetpack Compose 中的組件，用於顯示垂直滾動的數據列表。透過 `Lazy Column`，開發者可以實現僅加載當前可見項目的效果，提高性能。
- Navigate: 在 Android 中的 Compose 框架中，用於實現屏幕之間的導航，使得應用程序能夠在不同畫面間切換。
- News Navigator Screen: 負責導航應用程式的主要畫面，管理不同功能和模塊的畫面切換，通常包括底部導航欄。
- Details ViewModel: 負責處理詳細畫面的業務邏輯和狀態管理的 ViewModel。
- Side Effect: 表示在執行某些操作時引起的額外效果，例如在 UI 中顯示提示消息。在這裡，使用 MutableStateFlow 來管理 Side Effect。
- Bottom Navigation: 一種 UI 元素，通常位於畫面底部，提供導航到應用程式的不同部分的快速入口。在 Compose 中，使用 `BottomNavigation` 來實現。
- Compose Scaffold: Compose 框架中的一個組件，用於構建具有通用外觀的應用程式畫面。它包括頂部導航欄、底部導航欄等部分，可以輕鬆配置。
- Side Effect: 在這裡指的是一種用於通知 UI 有相關操作發生的概念，例如成功保存文章或刪除文章。在 Details Screen 中，使用 MutableState<String?> 來表示 side effect。
- Scaffold: 一種在 Compose 中使用的材料風格組件，用於構建 UI 的基本結構，包括頂部工具欄、底部導航欄等。
- Bottom Navigation: 底部導航欄，用於在應用程序的不同部分之間進行快速切換。
- Back Stack State: 在 Android 中，指導航堆棧的狀態，通常用於管理應用程序中各個屏幕之間的轉換和返回操作。
- ViewModel: 在 Android 中的 MVVM 架構中，用於處理 UI 相關邏輯和數據持久性的組件，確保 UI 的獨立性。
- Compose: Jetpack Compose，一個用於構建 Android UI 的現代 UI 工具包。
- Use Cases: 在軟體開發中，指應用程序中某個功能的使用場景或用例，以確保業務邏輯的清晰分離。
- MutableState: 在 Compose 中，一種可變的狀態，用於跟踪 UI 中的數據變化並觸發 UI 更新。
- Repository: 一種模式，用於將數據庫操作和數據來源的交互隔離，提供統一的接口供應用程序使用。
- Reverse: 將順序或列表進行反轉，改變元素的排列順序，以達到反向顯示的效果。
