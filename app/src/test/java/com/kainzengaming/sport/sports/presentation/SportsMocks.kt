import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport

val FULL_MOCK = listOf(
    Sport(
        id = "FOOT",
        name = "SOCCER",
        events = listOf(
            Event("49906591", "Birkenhead United - West Coast Rangers", 1723146960),
            Event("49925253", "S.L. Benfica (lion) (Esports) - Sevilla FC (Senior) (Esports)", 1723953180),
            Event("49925342", "Newcastle United (Wboy) (Esports) - AC Milan (nikkitta) (Esports)", 1720154220),
            Event("49924818", "Arsenal (labotryas) (Esports) - Manchester United (Fearggwp) (Esports)", 1734011520),
            Event("49924844", "Borussia Dortmund (MeLToSiK) (Esports) - SSC Napoli (Blackstar98) (Esports)", 1718777100),
            Event("49925287", "Sevilla FC (Senior) (Esports) - Newcastle United (Wboy) (Esports)", 1717700460),
            Event("49925343", "AC Milan (nikkitta) (Esports) - Internazionale (Koftovsky) (Esports)", 1721163840),
            Event("49928850", "Liverpool FC (Joshua) (Esports) - Manchester City FC (Arthur) (Esports)", 1733921580),
            Event("49928906", "Tottenham Hotspur FC (Palas) (Esports) - Arsenal FC (Panther) (Esports)", 1717884480),
            Event("49925998", "Portugal (KravaRK) (Esports) - Netherlands (danyab1ceps) (Esports)", 1733056440),
            Event("49926257", "England (Kent) (Esports) - Germany (Uncle) (Esports)", 1718086620),
            Event("49925894", "Germany (Uncle) (Esports) - Portugal (KravaRK) (Esports)", 1724564820),
            Event("49926260", "Netherlands (danyab1ceps) (Esports) - Argentina (Krisspyyy) (Esports)", 1718237040),
            Event("49925512", "Bayern Munich (Mars) (Esports) - Borussia Dortmund (Raul) (Esports)", 1721635320),
            Event("49925553", "VfB Stuttgart (Saigon) (Esports) - RB Leipzig (Ozil) (Esports)", 1732275420),
            Event("49958805", "Juventus (Furious) (Esports) - SSC Napoli (David) (Esports)", 1720768860),
            Event("49958811", "AS Roma (Cruise) (Esports) - AC Milan (Seagal) (Esports)", 1731448620),
            Event("49925547", "Juventus (Furious) (Esports) - AC Milan (Seagal) (Esports)", 1728161460),
            Event("49935153", "Bayer 04 Leverkusen (Prince) (Esports) - Bayern Munich (Mars) (Esports)", 1719907620),
            Event("49924720", "Manchester City (SpeciAL) (Esports) - Tottenham Hotspur (Lx7ss) (Esports)", 1725996360),
            Event("49925015", "Manchester United (Noltzer) (Esports) - Arsenal (maggett0) (Esports)", 1729527960)
        )
    ),
    Sport(
        id = "BASK",
        name = "BASKETBALL",
        events = listOf(
            Event("49613422", "Nelson Giants - Bay Hawks", 1731277860),
            Event("49905565", "Ateneo Blue Eagles - NU Bulldogs", 1724838180),
            Event("49905794", "Pasay Voyagers - Binan Tatak Gel", 1721676480),
            Event("49905807", "Sungkyunkwan University - Myongii University", 1723388220)
        )
    ),
    Sport(
        id = "TENN",
        name = "TENNIS",
        events = listOf(
            Event("49752704", "Horacio Zeballos / Marcel Granollers - Adrian Mannarino / Fabrice Martin", 1734859140),
            Event("49757758", "Magda Linette / Bernarda Pera - Camilla Rosatello / Angelica Moratelli", 1726679040),
            Event("49757868", "Elsa Jacquemot / Harmony Tan - Tereza Mihalikova / Linda Noskova", 1734417720),
            Event("49757952", "Caroline Dolehide / Desirae Krawczyk - Varvara Gracheva / Elixane Lechemia", 1728242100),
            Event("49931722", "Luigi Sorrentino - Leonardo Rossi", 1717970220),
            Event("49931859", "Joao Eduardo Schiessl - Stefano DAgostino", 1729465560),
            Event("49931131", "Matic Dimic - Jan Hrazdil", 1728035640),
            Event("49931132", "Federico Cina - Kai Wehnelt", 1734576540),
            Event("49872144", "Zhenxiong Dong - Xirui Han", 1725006540),
            Event("49931720", "Juan Bautista Otegui - Jay Clarke", 1727768400),
            Event("49931852", "Sean Hess - Svyatoslav Gulin", 1722526860),
            Event("49866938", "Milos Karol - Gregor Ramskogler", 1731271560),
            Event("49866939", "Federico Campana - Pawel Juszczak", 1731966720),
            Event("49926810", "Andrea Gola - Peter Fajta", 1721774640),
            Event("49926878", "Aleksandr Braynin - Gian Marco Ortenzi", 1721162700),
            Event("49928781", "Sebastian Eriksson - Gabriele Pennaforti", 1717795980),
            Event("49928789", "Conor Gannon - Adrian Oetzbach", 1719883980),
            Event("49928794", "Nikita Mashtakov - Alexey Zakharov", 1727683800),
            Event("49928799", "Duarte Vale - Hugo Ouzilou", 1721241120),
            Event("49872075", "Lucas Poullain - Theo Papamalamis", 1717246260),
            Event("49877863", "Alexey Vatutin - Antoine Ghibaudo", 1725983400),
            Event("49931698", "Ekaterina Ovcharenko - Julia Stamatova", 1721044920),
            Event("49931935", "Karola Patricia Bejenaru - Denise Valente", 1728176880),
            Event("49931950", "Dea Herdzelas - Ioana Zvonaru", 1731469560),
            Event("49931984", "Andreea Prisacariu - Galena Krastenova", 1720542720),
            Event("49931989", "Suana Tucakovic - Madelief Hageman", 1732297320),
            Event("49928869", "Sina Herrmann - Tessa Johanna Brockmann", 1727219940),
            Event("49928881", "Eleejah Inisan - Stephanie Judith Visscher", 1729396680),
            Event("49932033", "Victoria Jimenez Kasintseva - Maya Joint", 1735304280),
            Event("49932012", "Ayla Aksu - Valeriya Strakhova", 1727202840),
            Event("49932024", "Lina Gjorcheska - Maja Chwalinska", 1723189080),
            Event("49932029", "Amandine Hesse - Miriam Bianca Bulgaru", 1717514160),
            Event("49927608", "Arina Gabriela Vasilescu - Victoria Bosio", 1730656260),
            Event("49927609", "Mariya Poduraeva - Georgia Andreea Craciun", 1734827820),
            Event("49927610", "Krystyna Pochtovyk - Lavinia Tanasie", 1734486960),
            Event("49927894", "Wakana Sonobe - Sofia Costoulas", 1718553780),
            Event("49927920", "Marie Benoit - Julie Belgraver", 1718050500),
            Event("49911861", "Shunsuke Nakagawa / Yusuke Kusuhara - Yuhei Kono / Toru Horie", 1730881380),
            Event("49911603", "Kaichi Uchida / Kazuma Kawachi - S.Hazawa / Kokoro Isomura", 1726676400),
            Event("49913618", "Rigele Te / Evan Zhu - Chase Ferguson / Ying Ze Chen", 1721517240),
            Event("49900553", "Yaojie Zeng / Zhan Zheng - Zijiang Yang / Zhe Li", 1719713640),
            Event("49913236", "Hiromi Abe / Kanako Morisaki - Ramu Ueda / Ayaka Ozeki", 1730457300),
            Event("49911321", "Gabriella Da Silva Fick / Lizette Cabrera - Paige Mary Hourigan / Erika Sema", 1720108020)
        )
    ),
    Sport(
        id = "TABL",
        name = "TABLE TENNIS",
        events = listOf(
            Event("49913091", "David Tomasch - Alexander Hejduk", 1728679740),
            Event("49913440", "Vladimir Postelt - Simon Kadavy", 1729488840),
            Event("49913526", "Richard Vavricka - Radim Pokorny", 1721545920),
            Event("49914118", "Alois Kanak - Tomas Suta", 1732892580),
            Event("49845584", "Akito Itagaki - Anton Limonov", 1733728080),
            Event("49935599", "Emets Ihor - Stefan Yakimenko", 1734431220),
            Event("49935633", "Serhii Kryvoshyi - Mykhailo Syniavskyi", 1718718540),
            Event("49935625", "Bogdan Panchenko - Dmytro Kuzmenko", 1723040460),
            Event("49939249", "Jakub Rolik - Jan Hruska", 1718766180),
            Event("49939229", "Jan Slavicek - Radek Muller", 1724302560),
            Event("49918248", "Karol Wisniewski - Dosz Slawomir", 1724359380)
        )
    ),
    Sport(
        id = "VOLL",
        name = "VOLLEYBALL",
        events = listOf(
            Event("48068639", "France (W) - Japan (W)", 1733725080)
        )
    ),
    Sport(
        id = "ESPS",
        name = "ESPORTS",
        events = listOf(
            Event("49859042", "100 Thieves - FUT Esports", 1718265780)
        )
    ),
    Sport(
        id = "BCHV",
        name = "BEACH VOLLEYBALL",
        events = listOf(
            Event("49938658", "A.Hasegawa/M.Ishii - P.Jundzill/K.Legieta", 1733466300)
        )
    ),
    Sport(
        id = "BADM",
        name = "BADMINTON",
        events = listOf(
            Event("49917531", "Anthony Sinisuka Ginting - Jun Hao Leong", 1727060460),
            Event("49899640", "Takuro Hoki / Yugo Kobayashi - Chen Bo Yang / Liu Yi", 1730799960),
            Event("49894244", "Mayu Matsumoto / Wakana Nagahara - Ching Hui Chang / Ching Tun Yang", 1728509580),
            Event("49931875", "Ansal Yadav - Romeo Makboul", 1730067840),
            Event("49923330", "Prenana N. Shet - Chloe Mayer", 1727585580)
        )
    )
)


val FULL_MOCK_WITH_FAVORITES = listOf(
    Sport(
        id = "FOOT",
        name = "SOCCER",
        events = listOf(
            Event("49906591", "Birkenhead United - West Coast Rangers", 1723146960),
            Event("49925253", "S.L. Benfica (lion) (Esports) - Sevilla FC (Senior) (Esports)", 1723953180, true),
            Event("49925342", "Newcastle United (Wboy) (Esports) - AC Milan (nikkitta) (Esports)", 1720154220, true),
            Event("49924818", "Arsenal (labotryas) (Esports) - Manchester United (Fearggwp) (Esports)", 1734011520),
            Event("49924844", "Borussia Dortmund (MeLToSiK) (Esports) - SSC Napoli (Blackstar98) (Esports)", 1718777100),
            Event("49925287", "Sevilla FC (Senior) (Esports) - Newcastle United (Wboy) (Esports)", 1717700460),
            Event("49925343", "AC Milan (nikkitta) (Esports) - Internazionale (Koftovsky) (Esports)", 1721163840),
            Event("49928850", "Liverpool FC (Joshua) (Esports) - Manchester City FC (Arthur) (Esports)", 1733921580),
            Event("49928906", "Tottenham Hotspur FC (Palas) (Esports) - Arsenal FC (Panther) (Esports)", 1717884480, true),
            Event("49925998", "Portugal (KravaRK) (Esports) - Netherlands (danyab1ceps) (Esports)", 1733056440),
            Event("49926257", "England (Kent) (Esports) - Germany (Uncle) (Esports)", 1718086620),
            Event("49925894", "Germany (Uncle) (Esports) - Portugal (KravaRK) (Esports)", 1724564820),
            Event("49926260", "Netherlands (danyab1ceps) (Esports) - Argentina (Krisspyyy) (Esports)", 1718237040),
            Event("49925512", "Bayern Munich (Mars) (Esports) - Borussia Dortmund (Raul) (Esports)", 1721635320),
            Event("49925553", "VfB Stuttgart (Saigon) (Esports) - RB Leipzig (Ozil) (Esports)", 1732275420),
            Event("49958805", "Juventus (Furious) (Esports) - SSC Napoli (David) (Esports)", 1720768860, true),
            Event("49958811", "AS Roma (Cruise) (Esports) - AC Milan (Seagal) (Esports)", 1731448620),
            Event("49925547", "Juventus (Furious) (Esports) - AC Milan (Seagal) (Esports)", 1728161460),
            Event("49935153", "Bayer 04 Leverkusen (Prince) (Esports) - Bayern Munich (Mars) (Esports)", 1719907620),
            Event("49924720", "Manchester City (SpeciAL) (Esports) - Tottenham Hotspur (Lx7ss) (Esports)", 1725996360),
            Event("49925015", "Manchester United (Noltzer) (Esports) - Arsenal (maggett0) (Esports)", 1729527960)
        )
    ),
    Sport(
        id = "BASK",
        name = "BASKETBALL",
        events = listOf(
            Event("49613422", "Nelson Giants - Bay Hawks", 1731277860),
            Event("49905565", "Ateneo Blue Eagles - NU Bulldogs", 1724838180),
            Event("49905794", "Pasay Voyagers - Binan Tatak Gel", 1721676480),
            Event("49905807", "Sungkyunkwan University - Myongii University", 1723388220)
        )
    ),
    Sport(
        id = "TENN",
        name = "TENNIS",
        events = listOf(
            Event("49752704", "Horacio Zeballos / Marcel Granollers - Adrian Mannarino / Fabrice Martin", 1734859140),
            Event("49757758", "Magda Linette / Bernarda Pera - Camilla Rosatello / Angelica Moratelli", 1726679040),
            Event("49757868", "Elsa Jacquemot / Harmony Tan - Tereza Mihalikova / Linda Noskova", 1734417720),
            Event("49757952", "Caroline Dolehide / Desirae Krawczyk - Varvara Gracheva / Elixane Lechemia", 1728242100),
            Event("49931722", "Luigi Sorrentino - Leonardo Rossi", 1717970220),
            Event("49931859", "Joao Eduardo Schiessl - Stefano DAgostino", 1729465560),
            Event("49931131", "Matic Dimic - Jan Hrazdil", 1728035640),
            Event("49931132", "Federico Cina - Kai Wehnelt", 1734576540),
            Event("49872144", "Zhenxiong Dong - Xirui Han", 1725006540),
            Event("49931720", "Juan Bautista Otegui - Jay Clarke", 1727768400),
            Event("49931852", "Sean Hess - Svyatoslav Gulin", 1722526860),
            Event("49866938", "Milos Karol - Gregor Ramskogler", 1731271560),
            Event("49866939", "Federico Campana - Pawel Juszczak", 1731966720),
            Event("49926810", "Andrea Gola - Peter Fajta", 1721774640),
            Event("49926878", "Aleksandr Braynin - Gian Marco Ortenzi", 1721162700),
            Event("49928781", "Sebastian Eriksson - Gabriele Pennaforti", 1717795980),
            Event("49928789", "Conor Gannon - Adrian Oetzbach", 1719883980),
            Event("49928794", "Nikita Mashtakov - Alexey Zakharov", 1727683800),
            Event("49928799", "Duarte Vale - Hugo Ouzilou", 1721241120),
            Event("49872075", "Lucas Poullain - Theo Papamalamis", 1717246260),
            Event("49877863", "Alexey Vatutin - Antoine Ghibaudo", 1725983400),
            Event("49931698", "Ekaterina Ovcharenko - Julia Stamatova", 1721044920),
            Event("49931935", "Karola Patricia Bejenaru - Denise Valente", 1728176880),
            Event("49931950", "Dea Herdzelas - Ioana Zvonaru", 1731469560),
            Event("49931984", "Andreea Prisacariu - Galena Krastenova", 1720542720),
            Event("49931989", "Suana Tucakovic - Madelief Hageman", 1732297320),
            Event("49928869", "Sina Herrmann - Tessa Johanna Brockmann", 1727219940),
            Event("49928881", "Eleejah Inisan - Stephanie Judith Visscher", 1729396680),
            Event("49932033", "Victoria Jimenez Kasintseva - Maya Joint", 1735304280),
            Event("49932012", "Ayla Aksu - Valeriya Strakhova", 1727202840),
            Event("49932024", "Lina Gjorcheska - Maja Chwalinska", 1723189080),
            Event("49932029", "Amandine Hesse - Miriam Bianca Bulgaru", 1717514160),
            Event("49927608", "Arina Gabriela Vasilescu - Victoria Bosio", 1730656260),
            Event("49927609", "Mariya Poduraeva - Georgia Andreea Craciun", 1734827820),
            Event("49927610", "Krystyna Pochtovyk - Lavinia Tanasie", 1734486960),
            Event("49927894", "Wakana Sonobe - Sofia Costoulas", 1718553780),
            Event("49927920", "Marie Benoit - Julie Belgraver", 1718050500),
            Event("49911861", "Shunsuke Nakagawa / Yusuke Kusuhara - Yuhei Kono / Toru Horie", 1730881380),
            Event("49911603", "Kaichi Uchida / Kazuma Kawachi - S.Hazawa / Kokoro Isomura", 1726676400),
            Event("49913618", "Rigele Te / Evan Zhu - Chase Ferguson / Ying Ze Chen", 1721517240),
            Event("49900553", "Yaojie Zeng / Zhan Zheng - Zijiang Yang / Zhe Li", 1719713640),
            Event("49913236", "Hiromi Abe / Kanako Morisaki - Ramu Ueda / Ayaka Ozeki", 1730457300),
            Event("49911321", "Gabriella Da Silva Fick / Lizette Cabrera - Paige Mary Hourigan / Erika Sema", 1720108020)
        )
    ),
    Sport(
        id = "TABL",
        name = "TABLE TENNIS",
        events = listOf(
            Event("49913091", "David Tomasch - Alexander Hejduk", 1728679740),
            Event("49913440", "Vladimir Postelt - Simon Kadavy", 1729488840),
            Event("49913526", "Richard Vavricka - Radim Pokorny", 1721545920),
            Event("49914118", "Alois Kanak - Tomas Suta", 1732892580),
            Event("49845584", "Akito Itagaki - Anton Limonov", 1733728080),
            Event("49935599", "Emets Ihor - Stefan Yakimenko", 1734431220),
            Event("49935633", "Serhii Kryvoshyi - Mykhailo Syniavskyi", 1718718540),
            Event("49935625", "Bogdan Panchenko - Dmytro Kuzmenko", 1723040460),
            Event("49939249", "Jakub Rolik - Jan Hruska", 1718766180),
            Event("49939229", "Jan Slavicek - Radek Muller", 1724302560),
            Event("49918248", "Karol Wisniewski - Dosz Slawomir", 1724359380)
        )
    ),
    Sport(
        id = "VOLL",
        name = "VOLLEYBALL",
        events = listOf(
            Event("48068639", "France (W) - Japan (W)", 1733725080)
        )
    ),
    Sport(
        id = "ESPS",
        name = "ESPORTS",
        events = listOf(
            Event("49859042", "100 Thieves - FUT Esports", 1718265780)
        )
    ),
    Sport(
        id = "BCHV",
        name = "BEACH VOLLEYBALL",
        events = listOf(
            Event("49938658", "A.Hasegawa/M.Ishii - P.Jundzill/K.Legieta", 1733466300)
        )
    ),
    Sport(
        id = "BADM",
        name = "BADMINTON",
        events = listOf(
            Event("49917531", "Anthony Sinisuka Ginting - Jun Hao Leong", 1727060460),
            Event("49899640", "Takuro Hoki / Yugo Kobayashi - Chen Bo Yang / Liu Yi", 1730799960),
            Event("49894244", "Mayu Matsumoto / Wakana Nagahara - Ching Hui Chang / Ching Tun Yang", 1728509580),
            Event("49931875", "Ansal Yadav - Romeo Makboul", 1730067840),
            Event("49923330", "Prenana N. Shet - Chloe Mayer", 1727585580)
        )
    )
)

