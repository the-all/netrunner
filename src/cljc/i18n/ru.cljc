(ns i18n.ru)

(defn ru-quant [group1 group2 group3]
  (fn [[cnt]]
    (let [group (if (contains? #{5 6 7 8 9 10 11 12 13 14} (rem cnt 100))
                  group1
                  (condp contains? (rem cnt 10)
                    #{0 5 6 7 8 9} group1
                    #{1} group2
                    #{2 3 4} group3))]
      (str cnt " " group))))

(def translations
  {:missing ":ru missing text"
   :side {:corp "Корпорация"
          :runner "Бегущий"
          :any-side "Любая сторона"
          :all "Все"}
   :faction {:all "Все"
             :any-faction "Все фракции"
             :anarch "Анарх"
             :criminal "Криминал"
             :shaper "Шейпер"
             :adam "Адам"
             :apex "Апекс"
             :sunny-lebeau "Санни Лебо"
             :jinteki "Джинтеки"
             :haas-bioroid "Хаас-Биороид"
             :nbn "NBN"
             :weyland-consortium "Консорциум Вейланда"
             :neutral "Нейтральные"}
   :format {:all "Все"
            :any-format "Любой формат"
            :standard "Стандарт"
            :eternal "Вечный"
            :core-experience "Core Experience"
            :snapshot "Snapshot"
            :snapshot-plus "Snapshot Plus"
            :socr "SOCR"
            :sunset "Закат"
            :neo "Нео"
            :classic "Классический"
            :casual "Свободный"
            :system-gateway "Врата Системы"
            :startup "Стартап"}
    :set {:all "All"
         :draft "Draft"
         :core-set "Core Set"
         :genesis-cycle "Genesis Cycle"
         :what-lies-ahead "What Lies Ahead"
         :trace-amount "Trace Amount"
         :cyber-exodus "Cyber Exodus"
         :a-study-in-static "A Study in Static"
         :humanity-s-shadow "Humanity's Shadow"
         :future-proof "Future Proof"
         :creation-and-control "Creation and Control"
         :spin-cycle "Spin Cycle"
         :opening-moves "Opening Moves"
         :second-thoughts "Second Thoughts"
         :mala-tempora "Mala Tempora"
         :true-colors "True Colors"
         :fear-and-loathing "Fear and Loathing"
         :double-time "Double Time"
         :honor-and-profit "Honor and Profit"
         :lunar-cycle "Lunar Cycle"
         :upstalk "Upstalk"
         :the-spaces-between "The Spaces Between"
         :first-contact "First Contact"
         :up-and-over "Up and Over"
         :all-that-remains "All That Remains"
         :the-source "The Source"
         :order-and-chaos "Order and Chaos"
         :sansan-cycle "SanSan Cycle"
         :the-valley "The Valley"
         :breaker-bay "Breaker Bay"
         :chrome-city "Chrome City"
         :the-underway "The Underway"
         :old-hollywood "Old Hollywood"
         :the-universe-of-tomorrow "The Universe of Tomorrow"
         :data-and-destiny "Data and Destiny"
         :mumbad-cycle "Mumbad Cycle"
         :kala-ghoda "Kala Ghoda"
         :business-first "Business First"
         :democracy-and-dogma "Democracy and Dogma"
         :salsette-island "Salsette Island"
         :the-liberated-mind "The Liberated Mind"
         :fear-the-masses "Fear the Masses"
         :flashpoint-cycle "Flashpoint Cycle"
         :23-seconds "23 Seconds"
         :blood-money "Blood Money"
         :escalation "Escalation"
         :intervention "Intervention"
         :martial-law "Martial Law"
         :quorum "Quorum"
         :red-sand-cycle "Red Sand Cycle"
         :daedalus-complex "Daedalus Complex"
         :station-one "Station One"
         :earth-s-scion "Earth's Scion"
         :blood-and-water "Blood and Water"
         :free-mars "Free Mars"
         :crimson-dust "Crimson Dust"
         :terminal-directive-cycle "Terminal Directive Cycle"
         :terminal-directive-cards "Terminal Directive Cards"
         :terminal-directive-campaign "Terminal Directive Campaign"
         :revised-core-set "Revised Core Set"
         :kitara-cycle "Kitara Cycle"
         :sovereign-sight "Sovereign Sight"
         :down-the-white-nile "Down the White Nile"
         :council-of-the-crest "Council of the Crest"
         :the-devil-and-the-dragon "The Devil and the Dragon"
         :whispers-in-nalubaale "Whispers in Nalubaale"
         :kampala-ascendent "Kampala Ascendent"
         :reign-and-reverie "Reign and Reverie"
         :magnum-opus "Magnum Opus"
         :napd-multiplayer "NAPD Multiplayer"
         :system-core-2019 "System Core 2019"
         :ashes-cycle "Ashes Cycle"
         :downfall "Downfall"
         :uprising-booster-pack "Uprising Booster Pack"
         :uprising "Uprising"
         :magnum-opus-reprint "Magnum Opus Reprint"
         :salvaged-memories "Salvaged Memories"
         :system-gateway "Врата Системы"
         :system-update-2021 "Обновление Системы 2021"
         :borealis-cycle "Borealis Cycle"
         :midnight-sun-booster-pack "Midnight Sun Booster Pack"
         :midnight-sun "Midnight Sun"
         :parhelion "Parhelion"
         :liberation-cycle "Liberation Cycle"
         :the-automata-initiative "The Automata Initiative"
         :rebellion-without-rehearsal "Rebellion Without Rehearsal"
         :alt-art "Alt Art"
         :kysra-alt-arts "Kysra Alt Arts"
         :ntscape-navigator-alt-arts "Ntscape Navigator Alt Arts"
         :alternate "Alternate"
         :world-champion-2015 "World Champion 2015"
         :world-champion-2016 "World Champion 2016"
         :world-champion-2017 "World Champion 2017"
         :championship-2019 "Championship 2019"
         :gnk-2019 "GNK 2019"
         :championship-2020 "Championship 2020"
         :signed-championship-2020 "Signed Championship 2020"
         :previous-versions "Previous Versions"}
   :card-type {:all "Все"
               :identity "Роль"
               :agenda "Проект"
               :asset "Актив"
               :upgrade "Улучшение"
               :operation "Операция"
               :ice "Лёд"
               :event "Событие"
               :hardware "Устройство"
               :resource "Ресурс"
               :program "Программа"}
   :pronouns {:none "Не указаны"
              :any "Любые"
              :myodb "Не хочу указывать"
              :blank "[пусто]"
              :they "Они/их"
              :she "Она/её"
              :shethey "Она/они"
              :he "Он/его"
              :hethey "Он/они"
              :it "Оно"
              :ne "Ne/nem"
              :ve "Ve/ver"
              :ey "Ey/em"
              :zehir "Ze/hir"
              :zezir "Ze/zir"
              :xe "Xe/xem"}
   :chat {:title "Играть в Netrunner в браузере"
          :channels "Каналы"
          :send "Отправить"
          :placeholder "Напишите что-нибудь..."
          :delete "Удалить сообщение"
          :delete-all "Удалить все сообщения пользователя"
          :block "Заблокировать пользователя"
          :cancel "Отмена"
          :message-blocked (fn [[reason-str]] (str "Сообщение заблокировано" (when reason-str (str ": " reason-str))))
          :length-exceeded "Превышена длина"
          :rate-exceeded "Превышена частота"}
   :nav {:welcome "Правила"
         :chat "Чат"
         :cards "Карты"
         :deck-builder "Колоды"
         :play "Играть"
         :help "Помощь"
         :settings "Настройки"
         :stats "Статистика"
         :about "О нас"
         :tournaments "Турниры"
         :admin "Администратор"
         :users "Пользователи"
         :features "Возможности"
         :game-count (ru-quant "игр" "игра" "игры")}
   :menu {:settings :ru.nav/settings
          :logout "Отключиться"
          :admin :ru.nav/admin
          :moderator "Модератор"
          :donor "Спонсор"}
   :card-browser {:implementation-note "Implementation Note"
                  :search-hint "Искать карты"
                  :sort "Сортировать по"
                  :format "Формат"
                  :set "Набор"
                  :side "Сторона"
                  :faction "Фракция"
                  :type "Тип"
                  :clear "Сбросить"
                  :select-art "Выбрать изображение"
                  :selected-art "Выбранное изображение"
                  :update-success "Изображение обновлено"
                  :update-failure "Ошибка обновления изображения"
                  :memory "Память"
                  :cost "Цена"
                  :trash-cost "Цена сноса"
                  :strength "Сила"
                  :advancement "Требование к продвижению"
                  :agenda-points "Победные очки"
                  :min-deck "Минимальный размер колоды"
                  :inf-limit "Предел влияния"
                  :influence "Влияние"
                  :artist-info "Информация о художнике"
                  :more-info "Больше информации"
                  :sort-by {:faction "Фракция"
                            :name "Название"
                            :type "Тип"
                            :influence "Влияние"
                            :cost "Цена"
                            :set-number "Номер в наборе"}}
   :deck-builder {:loading-msg "Загрузка коллекции колод..."
                  :new-corp "Создать Корпу"
                  :new-runner "Создать Бегущего"
                  :import-button "Импорт колоды"
                  :reset "Сброс"
                  :import-title "Введите ID общедоступной колоды с NRDB или ссылку"
                  :import "Импортировать"
                  :cancel "Отмена"
                  :import-placeholder "ID с NRDB"
                  :deck-count (ru-quant "колод" "колода" "колоды")
                  :filtered "(filtered)"
                  :save "Сохранить"
                  :confirm-delete "Подтвердить удаление"
                  :edit "Редактировать"
                  :delete "Удалить"
                  :copy "Скопировать"
                  :deck-copy-suffix "копия"
                  :clear-stats "Сбросить статистику"
                  :create-game "Создать игру"
                  :new-deck "Новая колода"
                  :deck-name "Название колоды"
                  :format "Формат"
                  :identity "Роль"
                  :deck-notes "Примечания"
                  :decklist "Список карт"
                  :decklist-inst "(Напишите или вставьте список карт, он будет распознан)"
                  :notes "Примечания"
                  :add-to-deck "Добавить в колоду"
                  :add-cards "Добавить карты"
                  :card-name "Название карты"
                  :no-decks "Нет колод"
                  :cards "карты"
                  :min "минимум"
                  :max "максимум"
                  :influence "Влияние"
                  :agenda-points "Победные очки"
                  :deck-points "Очки колоды"
                  :hash "Турнирный хеш"
                  :why "Почему?"
                  :legal ": легальна"
                  :illegal ": нелегальна"
                  :games "Игр"
                  :completed "Зав."
                  :won "Побед"
                  :lost "Пр."}
     :game-prompt {:trash "снести"
                 :advance "продвинуть"
                 :score "засчитать"
                 :rez "развернуть"
                 :derez "свернуть"
                 :expend "израсходовать"
                 :archives "Архивы"
                 :hq "HQ"
                 :r-d "R&D"
                 :new-remote "Новый сервер"
                 :server-1 "Сервер 1"
                 :server-2 "Сервер 2"
                 :server-3 "Сервер 3"
                 :server-4 "Сервер 4"
                 :server-5 "Сервер 5"
                 :server-6 "Сервер 6"
                 :server-7 "Сервер 7"
                 :server-8 "Сервер 8"
                 :server-9 "Сервер 9"
                 :server-10 "Сервер 10"}
   :lobby {:no-games "Нет игр"
           :tournament "Турнирные"
           :competitive "Соревновательные"
           :casual "Обычные"
           :angel-arena "Арена Ангелов"
           :new-game "Новая игра"
           :reload "Перезагрузить список"
           :load-replay "Загрузить повтор"
           :start-replay "Начать повтор"
           :save-replay "Сохранить повтор"
           :create "Создать"
           :cancel "Отмена"
           :title "Название"
           :side "Сторона"
           :format "Формат"
           :default-game-format "Формат по умолчанию"
           :singleton "Одиночка"
           :singleton-b "(одиночка)"
           :singleton-details "С данной опцией играть можно только колодами без повторяющихся карт. Рекомендуется использовать следующие карты ролей."
           :singleton-example "1) Nova Initiumia: Catalyst & Impetus 2) Ampere: Cybernetics For Anyone"
           :singleton-restriction "Данная комната запущена в режиме \"Одиночка\". Играть можно только колодами без повторяющихся карт."
           :options "Параметры"
           :spectators "Допустить зрителей"
           :hidden "Раскрыть зрителям скрытую информацию"
           :hidden-details "Данная опция раскроет всю скрытую информацию обеих сторон для ВСЕХ зрителей вашей игры, в том числе руки и карты лицом вниз."
           :hidden-password "Мы рекомендуем использовать пароль, чтобы посторонние не помешали вашей игре."
           :password-protected "Защитить паролем"
           :password "Пароль"
           :timed-game "Запустить таймер"
           :timer-length "Продолжительность таймера (минут)"
           :timed-game-details "Таймер носит информационный характер: игра будет продолжаться, когда время выйдет."
           :save-replay-details "Данная опция сохранит повтор игры с открытой информацией (например, о картах в руке). Файл будет доступен по завершении игры."
           :save-replay-unshared "Мы храним 15 ваших последних повторов, которыми вы не делились, так что не забудьте скачать или поделиться повтором после игры."
           :save-replay-beta "БЕТА функционал: У нас может возникнуть необходимость удалить сохранённые повторы, поэтому обязательно скачивайте важные для вас записи игр. Будущие изменения функционала сайта могут нарушить совместимость со старыми повторами."
           :replay-link-error "Ссылка на повтор недействительна."
           :replay-invalid-file "Выберите подходящий файл повтора."
           :corp-perspective "Перспектива Корпорации"
           :runner-perspective "Перспектива Бегущего"
           :both-perspective "Перспектива обоих"
           :start "Начать"
           :leave "Выйти"
           :swap "Изменить стороны"
           :waiting "Игроки выбирают колоды"
           :players "Игроки"
           :deck-selected "Колода выбрана"
           :select-deck "Выбрать колоду"
           :chat "Чат"
           :select-error "Невозможно выбрать эту колоду"
           :select-title "Выберите вашу колоду"
           :spectator-count (ru-quant "зрителей" "зритель" "зрителя")
           :closed-msg "Лобби закрыто из-за отсутствия активности"
           :title-error "Пожалуйста, введите название игры."
           :password-error "Пожалуйста, введите пароль."
           :too-little-data "Слишком мало данных"
           :completion-rate "Процент завершённых игр"
           :watch "Смотреть"
           :join "Войти"
           :rejoin "Перезайти"
           :as-corp "За Корпорацию"
           :as-runner "За Бегущего"
           :private "ЧАСТНОЕ"
           :reset "Сбросить название игры"
           :delete "Удалить игру"
           :password-for "Пароль для"
           :invalid-password "Неправильный пароль"
           :not-allowed "Не разрешено"
           :aborted "Соединение разорвано"
           :game-count (ru-quant "игр" "игра" "игры")
           :api-access "Разрешить доступ к данным игры через API"
           :api-requires-key "(Требуется ключ API в Настройках)"
           :api-access-details "Данная опция даёт доступ к информации о вашей игре расширенияим от сторонних разработчиков. Требует создание ключа API в Настройках."
           :filter "Фильтр"
           :filtered "(с фильтром)"}
     :angel-arena {:cancel-match "Отменить матч"
                 :claim-victory "Объявить победу"
                 :still-here "Нужно больше времени"
                 :abandon-run "Покинуть забег"
                 :active-corp-run "Активный забег за Корпорацию"
                 :active-runner-run "Активный забег за Бегущего"
                 :are-you-sure "Вы уверены?"
                 :are-you-sure-no "нет"
                 :are-you-sure-yes "да"
                 :format "Формат"
                 :latest-runs "Последние забеги"
                 :no-eligible-decks "Не найдено легальных колод для этой стороны и формата."
                 :no-games "Нет игр"
                 :queue-for-match "Встать в очередь на матч"
                 :queueing "Встаём в очередь..."
                 :requesting-run-data "Запрашиваем данные забега..."
                 :select-deck "Выберите вашу колоду"
                 :start-new-run "Начать новый забег"
                 :wins (ru-quant "побед" "победа" "победы")}
   :settings {:invalid-password "Неправильный логин или пароль"
              :invalid-email "Учётной записи с таким адресом электронной почты не существует"
              :updated "Профиль обновлён. Пожалуйста, обновите страницу браузера"
              :updating "Обновление профиля..."
              :get-log-width "Записать текущую ширину журнала"
              :get-log-top "Записать текущую высоту журнала"
              :email-title "Изменить адрес электронной почты"
              :current-email "Текущий адрес"
              :desired-email "Новый адрес"
              :email-placeholder "Адрес электронной почты"
              :enter-valid "Пожалуйста, введите корректный адрес электронной почты"
              :update "Обновить"
              :cancel "Отмена"
              :email "Электронная почта"
              :change-email "Изменить адрес электронной почты"
              :avatar "Аватар"
              :change-avatar "Изменить на gravatar.com"
              :pronouns "Местоимения"
              :language "Язык"
              :sounds "Звуки"
              :enable-lobby-sounds "Включить звуки в комнате"
              :enable-game-sounds "Включить звуки в игре"
              :volume "Громкость"
              :layout-options "Настройки расположения"
              :player-stats-icons "Использовать иконки в игровой статистике"
              :stacked-cards "Складывать вместе одинаковые карты (по умолчанию включено)"
              :ghost-trojans "Отображать бледные дубликаты программ-троянов, установленных на карты-носители"
              :sides-overlap "Столы Бегущего и Корпорации могут перекрывать друг друга"
              :runner-layout "Раскладка Бегущего при игре за Корпорацию"
              :runner-classic "Классическая раскладка Бегущего (Сверху вниз: Программы, Устройства, Ресурсы)"
              :runner-reverse "Обратная раскладка Бегущего (Сверху вниз: Ресурсы, Устройства, Программы)"
              :log-size "Размер журнала"
              :log-player-highlight "Подсвечивать игроков в журнале"
              :log-player-highlight-red-blue "Корпорация: Синий / Бегущий: Красный"
              :log-player-highlight-none "Не подсвечивать"
              :card-preview-zoom "Увеличение карт при наведении"
              :card-iamge "Изображение карты"
              :card-text "Текст карты"
              :pin-zoom "Оставлять последнюю увеличенную на экране"
              :background "Фон игрового поля"
              :the-root-bg "The Root"
              :freelancer-bg "Freelancer"
              :mushin-no-shin-bg "Mushin No Shin"
              :traffic-jam-bg "Traffic Jam"
              :rumor-mill-bg "Rumor Mill"
              :find-the-truth-bg "Find The Truth"
              :push-your-luck-bg "Push Your Luck"
              :apex-bg "Apex"
              :worlds2020-bg "Чемпионат мира 2020"
              :monochrome-bg "Монотонный"
              :custom-bg "Индивидуальный фон"
              :input-url-below "(вставьте ссылку ниже)"
              :card-backs "Рубашки карт"
              :game-stats "Учёт статистики побед/поражений"
              :deck-stats "Учёт статистики колод"
              :always "Всегда"
              :comp-only "Только в соревновательном лобби"
              :none "Не учитывать"
              :alt-art "Альтернативные изображения карт"
              :show-alt "Показывать альтернативные изображения карт"
              :high-res "Включить загрузку изображений высокого разрешения"
              :card-images "Изображения карт"
              :set-all "Изменить все карты на"
              :set "Изменить"
              :reset "Сбросить до официальных изображений"
              :blocked "Заблокированные пользователи"
              :user-name "Имя пользователя"
              :block "Заблокировать пользователя"
              :update-profile "Обновить профиль"
              :nsg "NSG"
              :ffg "FFG"
              :api-keys "Ключи API"
              :delete-api-key "Удалить"
              :create-api-key "Создать ключ API"}
     :ingame-settings {:card-stacking "Настройки карт"
                     :stack-cards "Складывать одинаковые карты"
                     :label-unrezzed-cards "Подписывать неразвёрнутые карты"
                     :label-faceup-cards "Подписывать карты лицом вверх"
                     :ghost-trojans "Показывать дубликаты троянов в риге"
                     :card-sorting "Сортировка"
                     :sort-archives "Отсортировать Архивы"
                     :sort-heap "Отсортировать Кучу"
                     :runner-board-order "Раскладка Бегущего"
                     :runner-classic "классическая"
                     :runner-reverse "обратная"
                     :board-overlap "Пересечение столов"
                     :sides-overlap "Карты Бегущего и Корпорации могут пересекаться"
                     :card-backs "Рубашки"
                     :preview-zoom "Увеличение карт при наведении"
                     :card-image "Изображение карты"
                     :card-text "Текст карты"
                     :card-images "Изображения карт"
                     :high-res "Включить изображения высокого разрешения"
                     :alt-art "Альтернативные изображения"
                     :show-alt "Показывать альтернативные изображения карт"
                     :save "Сохранить"}
   :stats {:game-stats "Игровая статистика"
           :corp-stats "Статистика за Корпорацию"
           :runner-stats "Статистика за Бегущего"
           :clear-stats "Очистить статистику"
           :no-log "Журнал недоступен"
           :view-log "Смотреть журнал"
           :winner "Победитель"
           :no-games "Нет игр"
           :all-games "Показать все игры"
           :shared-games "Показать игры с публичными повторами"
           :started "Начато"
           :ended "Закончено"
           :completed "Завершено"
           :not-completed "Не завершено"
           :won "Выиграно"
           :lost "Проиграно"
           :turn-count (ru-quant "ходов" "ход" "хода")
           :lobby "Комната"
           :format "Формат"
           :win-method "Способ победы"
           :view-games "Вернуться к статистике"
           :share "Поделиться повтором"
           :launch "Запустить повтор"
           :download "Скачать повтор"
           :unavailable "Повтор недоступен"
           :filtered "(отфильтровано)"
           :log-count (ru-quant "журналов" "журнал" "журнала")
           :clicks-gained "Получено кликов"
           :credits-gained "Получено кредитов"
           :credits-spent "Потрачено кредитов"
           :credits-click "Получено кредитов за клики"
           :cards-drawn "Взято карт"
           :cards-click "Взято карт за клики"
           :damage-done "Нанесено урона"
           :cards-rezzed "Развёрнуто карт"
           :tags-gained "Получено меток"
           :runs-made "Совершено забегов"
           :shuffle-count "Перемешиваний колоды"
           :operations-played "Разыграно операций"
           :cards-sabotaged "Сброшено карт от саботажа"
           :events-played "Разыграно событий"
           :unique-accesses "Уникальных карт в доступе"
           :psi-game-total "Пси-игры: Сыграно игр"
           :psi-game-total-wins "Пси-игры: Побед"
           :psi-game-total-bid-0 "Пси-игры: Ставка 0"
           :psi-game-total-bid-1 "Пси-игры: Ставка 1"
           :psi-game-total-bid-2 "Пси-игры: Ставка 2"
           :rashida-count "Разыграно карт Rashida Jaheem"
           :cards-accessed "Карт в доступе"}
   :log {:game-log "Журнал игры"
         :settings "Настройки"
         :annotating "Аннотации"
         :run-timing "Структура забега"
         :turn-timing "Структура хода"
         :shared "Опубликованные аннотации"
         :remote-annotations-fail "Не удалось загрузить аннотации."}
   :annotations {:turn-placeholder "Заметки к этому ходу"
                 :click-placeholder "Заметки к этому клику"
                 :available-annotations "Доступные аннотации"
                 :no-published-annotations "Нет опубликованных аннотаций."
                 :publish "Опубликовать"
                 :import-local "Импортировать файл с аннотациями"
                 :load-local "Загрузить"
                 :save-local "Сохранить"
                 :clear "Очистить локальные аннотации"}
   :diagrams {:turn {:corp-turn "Ход Корпорации"
                     :corp-draw-phase "5.6.1: Фаза добора"
                     :corp-draw-phase-a "Корпорация получает полагающиеся клики (по умолчанию: [click][click][click])"
                     :corp-draw-phase-b "Окно платной способности. Корпорация может разворачивать карты, кроме льдов, и засчитывать проекты"
                     :corp-draw-phase-c "Обновляются возобновляемые кредиты Корпорации"
                     :corp-draw-phase-d "Ход формально начинается. Срабатывают карты с формулировкой 'в начале хода'"
                     :corp-draw-phase-e "Корпорация берёт 1 карту с верха R&D"
                     :corp-draw-phase-f "Перейдите к фазе действий (5.6.2)"
                     :corp-action-phase "5.6.2: Фаза действий"
                     :corp-action-phase-a "Окно платной способности. Корпорация может разворачивать карты, кроме льдов, и засчитывать проекты"
                     :corp-action-phase-b "Если у Корпорации есть непотраченные [Clicks], она совершает действие"
                     :corp-action-phase-c "Если действие было совершено, вернитесь к (a)"
                     :corp-action-phase-d "Фаза действий завершена. Перейдите к фазе сброса (5.6.3)"
                     :corp-discard-phase "5.6.3: Фаза сброса"
                     :corp-discard-phase-a "Корпорация сбрасывает карты до максимального размера руки при необходимости"
                     :corp-discard-phase-b "Окно платной способности. Корпорация может разворачивать карты, кроме льдов"
                     :corp-discard-phase-c "Если у Корпорации остались [Clicks], она теряет эти [Clicks]"
                     :corp-discard-phase-d "Ход Корпорации формально окончен. Срабатывают карты с формулировкой 'в конце хода'"
                     :corp-discard-phase-e "Перейдите к ходу Бегущего"
                     :runner-turn "Ход Бегущего"
                     :runner-action-phase "5.7.1: Фаза действий"
                     :runner-action-phase-a "Бегущий получает полагающиеся клики (по умолчанию: [click][click][click][click])"
                     :runner-action-phase-b "Окно платной способности. Корпорация может разворачивать карты, кроме льдов"
                     :runner-action-phase-c "Обновляются возобновляемые кредиты Бегущего"
                     :runner-action-phase-d "Ход формально начинается. Срабатывают карты с формулировкой 'в начале хода'"
                     :runner-action-phase-e "Окно платной способности. Корпорация может разворачивать карты, кроме льдов"
                     :runner-action-phase-f "Если у Бегущего есть непотраченные [Clicks], он совершает действие"
                     :runner-action-phase-g "Если действие было совершено, вернитесь к (e)"
                     :runner-action-phase-h "Фаза действий завершена. Перейдите к фазе сброса (5.7.2)"
                     :runner-discard-phase "5.7.2: Фаза сброса"
                     :runner-discard-phase-a "Бегущий сбрасывает карты до максимального размера руки при необходимости"
                     :runner-discard-phase-b "Окно платной способности. Корпорация может разворачивать карты, кроме льдов"
                     :runner-discard-phase-c "Если у Бегущего остались [Clicks], он теряет эти [Clicks]"
                     :runner-discard-phase-d "Ход Бегущего формально окончен. Срабатывают карты с формулировкой 'в конце хода'"
                     :runner-discard-phase-e "Перейдите к ходу Корпорации"}
              :run-timing {:header "Структура забега"
                           :disclaimer "Данная схема была упрощена для наглядности. Полные правила можно изучить на сайте Null Signal Games."
                           :initiation "6.9.1: Фаза инициации"
                           :initiation-a "Бегущий объявляет сервер"
                           :initiation-b "Бегущий получает кредиты плохой репутации"
                           :initiation-c "Забег формально начинается - Срабатывают эффекты событий-забегов"
                           :initiation-d "Перейдите к внешнему льду при его наличии и начните фазу приближения (6.9.2)"
                           :initiation-e "В противном случае перейдите к фазе движения (6.9.4)"
                           :approach "6.9.2: Фаза приближения ко льду"
                           :approach-a "Вы приближаетесь ко льду. Срабатывают соответствующие эффекты карт"
                           :approach-b "Окно платной способности. Корпорация может развернуть лёд, к которому приближается Бегущий, а также другие карты, помимо льдов"
                           :approach-c "Если лёд, к которому приближается Бегущий, развёрнут, перейдите к фазе встречи (6.9.3)"
                           :approach-d "В противном случае перейдите к фазе движения (6.9.4)"
                           :encounter "6.9.3: Фаза встречи со льдом"
                           :encounter-a "Вы встретились с данным льдом. Срабатывают соответствующие эффекты карт"
                           :encounter-b "Окно платной способности. Бегущий может контактировать со льдом во время этого окна"
                           :encounter-c "Если остались несломанные подпрограммы, Корпорация выполняет верхнюю несломанную подпрограмму. По завершении повторите этот шаг"
                           :encounter-d "Встреча завершена. Перейдите к фазе движения (6.9.4)"
                           :movement "6.9.4: Фаза движения"
                           :movement-a "Если вы были во встрече со льдом или приближались ко льду, вы его проходите. Срабатывают карты с формулировкой 'при прохождении льда'"
                           :movement-b "Если между вами и корнем сервера не осталось больше льдов, срабатывают карты с формулировкой 'при прохождении всех льдов на сервере'"
                           :movement-c "Окно платной способности"
                           :movement-d "Бегущий может отключиться. Если Бегущий отключился, перейдите к фазе завершения забега (6.9.6)"
                           :movement-e "Бегущий продвигается на одну позицию по направлению к корню сервера, если это возможно"
                           :movement-f "Окно платной способности. Корпорация может разворачивать карты, кроме льдов"
                           :movement-g "Если вы приближаетесь ко льду, перейдите к фазе приближения ко льду (6.9.2)"
                           :movement-h "Бегущий приближается к атакуемому серверу. Срабатывают соответствующие эффекты карт"
                           :movement-i "Перейдите к фазе успеха (6.9.5)"
                           :success "6.9.5: Фаза успеха"
                           :success-a "Забег объявляется успешным. Срабатывают карты с формулировкой 'при успешном забеге'"
                           :success-b "Бегущий взламывает атакуемый сервер"
                           :success-c "Фаза успеха завершена. Перейдите к фазе завершения забега (6.9.6)"
                           :run-ends "6.9.6: Фаза завершения забега"
                           :run-ends-a "Все открытые окна приоритета завершаются или закрываются"
                           :run-ends-b "Бегущий теряет все непотраченные кредиты плохой репутации"
                           :run-ends-c "Если данной фазе не предшествовала фаза успеха, а сервер всё ещё существует, забег объявляется неуспешным"
                           :run-ends-d "Забег завершается. Срабатывают карты с формулировкой 'по завершении забега'"}}
   :game {:ok "OK"
          :error "Внутренняя ошибка сервера. Пожалуйста, напишите /bug в чат и следуйте инструкциям."
          :set-aside "Отложить в сторону"
          :keep "Оставить"
          :mulligan "Пересдать"
          :close "Закрыть"
          :start "Начать игру"
          :remove-tag "Снять метку"
          :run "Начать забег"
          :purge "Сбросить вирусы"
          :trash-resource "Снести ресурс"
          :draw "Взять карту"
          :gain-credit "Получить кредит"
          :game-start "Начало игры"
          :start-turn "Начать ход"
          :end-turn "Закончить ход"
          :mandatory-draw "Карта за начало хода"
          :take-clicks "Получить клики"
          :hq "HQ"
          :grip "Рука"
          :rfg "Удалены из игры"
          :play-area "Игровая зона"
          :current "Течение"
          :scored-area "Зона зачёта"
          :archives "Архивы"
          :max-hand "Макс. размер руки"
          :brain-damage "Критический урон"
          :tag-count (let [tag-quant (ru-quant "меток" "метка" "метки")] (fn [[base additional]] (str (tag-quant [base]) (when (pos? additional) (str " + " additional)))))
          :agenda-count (ru-quant "победных очков" "победное очко" "победных очка")
          :link-strength "Мощность канала"
          :credit-count (let [credit-quant (ru-quant "кредитов" "кредит" "кредита")] (fn [[credit run-credit]] (str (credit-quant [credit]) (when (pos? run-credit) (str " (" run-credit " для забега)")))))
          :click-count (ru-quant "кликов" "клик" "клика")
          :bad-pub-count (let [bp-quant (ru-quant "плохих репутаций" "плохая репутация" "плохих репутации")] (fn [[base additional]] (str (bp-quant [base]) (when (pos? additional) (str " + " additional)))))
          :mu-count (fn [[unused available]] (str unused " из " available " свободных ЯП"))
          :special-mu-count (fn [[unused available mu-type]] (str unused " из " available " " mu-type " свободных ЯП"))
          :indicate-action "Обозначить действие"
          :spec-count (ru-quant "зрителей" "зритель" "зрителя")
          :spec-view "Перспектива зрителя"
          :runner-view "Перспектива Бегущего"
          :corp-view "Перспектива Корпорации"
          :leave-replay "Выйти из повтора"
          :leave "Выйти из игры"
          :unmute "Включить сообщения зрителей"
          :mute "Выключить сообщения зрителей"
          :concede "Сдаться"
          :inactivity "Игра закрыта из-за отсутствия активности"
          :server "Сервер"
          :unimplemented "Не реализовано"
          :abilities "Способности"
          :subs "Подпрограммы"
          :let-subs-fire "Разрешить выполнение несломанных подпрограмм"
          :fire-unbroken "Выполнить несломанные подпрограммы"
          :actions "Действия"
          :stack "Стек"
          :r&d "R&D"
          :shuffle "Перемешать"
          :show "Показать"
          :close-shuffle "Закрыть и перемешать"
          :heap "Куча"
          :card-count (ru-quant "карт" "карта" "карты")
          :face-down-count (let [facedown-quant (ru-quant "карт" "карта" "карты")] (fn [[total face-up]] (str (facedown-quant [total]) ", " (- total face-up) " лицом вниз.")))
          :up-down-count (fn [[total face-up]] (str face-up "↑ " (- total face-up) "↓"))
          :initiation "Инициация"
          :approach-ice "Приближение ко льду"
          :encounter-ice "Встреча со льдом"
          :movement "Движение"
          :breach-server "Взломать сервер"
          :success "Успех"
          :run-ends "Забег завершается"
          :no-current-run "Нет активного забега"
          :current-phase "Текущая фаза"
          :unknown-phase "Неизвестная фаза"
          :rez "Развернуть"
          :no-further "Нет дальнейших действий"
          :continue "Продолжить"
          :continue-to "Продолжить к"
          :stop-auto-pass "Прекратить автопередачу приоритета"
          :auto-pass "Автопередача приоритета"
          :jack-out "Отключиться"
          :trace "Отследить"
          :beat-trace "Перебить слежку"
          :unbeatable "Сделать неперебиваемой"
          :credits "кредитов"
          :card "Карта"
          :minutes "м:"
          :seconds "с"
          :seconds-remaining "с осталось"
          :time-taken (fn [[t]] (str "Затраченное время: " t " минут"))
          :win-decked (fn [[turn]] (str "побеждает. Соперник не смог взять карту из R&D на " turn " ходу"))
          :win-flatlined (fn [[turn]] (str "побеждает. Соперник получил флетлайн на " turn " ходу"))
          :win-conceded (fn [[turn]] (str "побеждает. Соперник сдался на " turn " ходу"))
          :win-claimed (fn [[turn]] (str "объявляет победу на  " turn " ходу"))
          :win-points (fn [[turn]] (str "побеждает, засчитав победные очки на " turn " ходу"))
          :win-other (fn [[turn reason]] (str "побеждает из-за " reason " на " turn " ходу"))}})