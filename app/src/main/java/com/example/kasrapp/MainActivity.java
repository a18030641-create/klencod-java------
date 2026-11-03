<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>عالم الكاسر للعبارات</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- FontAwesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Google Arabic Font: Cairo -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@400;600;700;800;900&display=swap" rel="stylesheet">
    
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        gold: {
                            100: '#fdf8d5',
                            200: '#f9ed9c',
                            300: '#f5de60',
                            400: '#edd032',
                            500: '#d4af37',
                            600: '#aa820a',
                            700: '#846200',
                            800: '#5c4300',
                            900: '#382800',
                        }
                    },
                    fontFamily: {
                        cairo: ['Cairo', 'sans-serif'],
                    }
                }
            }
        }
    </script>
    <style>
        body {
            font-family: 'Cairo', sans-serif;
            background-color: #0d0e12;
            color: #ffffff;
            touch-action: manipulation;
        }
        
        /* البطاقة الذهبية الفاخرة */
        .gold-card {
            background: linear-gradient(145deg, #ffd700 0%, #e6b800 40%, #b8860b 100%);
            border: 1px solid #ffe57f;
            box-shadow: 0 4px 15px rgba(212, 175, 55, 0.2), inset 0 1px 1px rgba(255, 255, 255, 0.8);
            transition: all 0.25s ease-in-out;
        }
        
        .gold-card:active {
            transform: scale(0.95);
            box-shadow: 0 2px 8px rgba(212, 175, 55, 0.4);
        }

        /* تأثيرات التوهج والنصوص الذهبية */
        .gold-text-gradient {
            background: linear-gradient(135deg, #fff2a3 0%, #d4af37 50%, #aa820a 100%);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .gold-header {
            background: linear-gradient(180deg, #1f1b0c 0%, #0d0e12 100%);
            border-bottom: 2px solid #d4af37;
        }

        /* تخصيص شريط التمرير */
        ::-webkit-scrollbar {
            width: 6px;
        }
        ::-webkit-scrollbar-track {
            background: #121212;
        }
        ::-webkit-scrollbar-thumb {
            background: #d4af37;
            border-radius: 4px;
        }
    </style>
</head>
<body class="min-h-screen flex flex-col justify-between selection:bg-gold-500 selection:text-black">

    <!-- Top App Bar / Header -->
    <header class="gold-header sticky top-0 z-40 px-4 py-3 shadow-lg backdrop-blur-md bg-opacity-90">
        <div class="max-w-4xl mx-auto flex items-center justify-between">
            <div class="flex items-center space-x-3 space-x-reverse">
                <div class="w-10 h-10 rounded-full bg-gradient-to-tr from-gold-600 to-gold-300 p-0.5 shadow-md flex items-center justify-center">
                    <div class="w-full h-full bg-black rounded-full flex items-center justify-center">
                        <i class="fa-solid fa-crown text-gold-400 text-lg"></i>
                    </div>
                </div>
                <div>
                    <h1 class="text-xl font-black gold-text-gradient tracking-wide">عالم الكاسر للعبارات</h1>
                    <p class="text-xs text-gold-200 opacity-80">أكبر موسوعة مسجات وحالات ذهبية</p>
                </div>
            </div>

            <!-- أزرار الإجراءات في الهيدر -->
            <div class="flex items-center space-x-2 space-x-reverse">
                <button onclick="openAddModal()" class="bg-gradient-to-r from-gold-500 to-gold-600 hover:from-gold-400 hover:to-gold-500 text-black font-bold text-xs px-3 py-2 rounded-xl shadow-md flex items-center gap-1 transition">
                    <i class="fa-solid fa-plus text-sm"></i>
                    <span class="hidden sm:inline">إضافة عبارة</span>
                </button>
            </div>
        </div>

        <!-- شريط البحث -->
        <div class="max-w-4xl mx-auto mt-3">
            <div class="relative">
                <input type="text" id="searchInput" onkeyup="filterCategories()" placeholder="ابحث عن قسم أو عبارة هنا..." 
                    class="w-full bg-gray-900/90 border border-gold-500/50 text-white placeholder-gray-400 text-sm rounded-2xl py-2.5 px-10 focus:outline-none focus:border-gold-400 focus:ring-2 focus:ring-gold-500/30 transition">
                <i class="fa-solid fa-magnifying-glass absolute right-3.5 top-3.5 text-gold-400 text-sm"></i>
                <button id="clearSearch" onclick="resetSearch()" class="hidden absolute left-3 top-2.5 text-gray-400 hover:text-white">
                    <i class="fa-solid fa-circle-xmark"></i>
                </button>
            </div>
        </div>
    </header>

    <!-- Main Content Container -->
    <main class="max-w-4xl mx-auto px-3 py-4 flex-grow w-full">
        <!-- شريط إحصائيات علوي -->
        <div class="bg-gradient-to-r from-gray-900 via-gold-900/20 to-gray-900 border border-gold-500/30 rounded-2xl p-3 mb-4 flex justify-between items-center text-xs text-gold-200 shadow-md">
            <div class="flex items-center gap-2">
                <i class="fa-solid fa-layer-group text-gold-400 text-sm"></i>
                <span>الأقسام: <strong id="totalCatCount" class="text-white font-bold">54</strong> قسم</span>
            </div>
            <div class="flex items-center gap-2">
                <i class="fa-solid fa-envelope-open-text text-gold-400 text-sm"></i>
                <span>إجمالي الرسائل: <strong class="text-white font-bold">+150,000</strong> مسج</span>
            </div>
        </div>

        <!-- Grid Cards Categories Container -->
        <div id="categoriesGrid" class="grid grid-cols-3 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 gap-2.5 sm:gap-3.5">
            <!-- سيتم توليد الـ 54 قسم هنا بالكامل من محرك JavaScript -->
        </div>

        <!-- حالة عدم وجود نتائج عند البحث -->
        <div id="noResults" class="hidden text-center py-12">
            <i class="fa-solid fa-box-open text-4xl text-gray-600 mb-3"></i>
            <p class="text-gray-400 text-sm">لم يتم العثور على نتائج تطابق بحثك</p>
        </div>
    </main>

    <!-- Footer -->
    <footer class="bg-black/80 border-t border-gold-500/20 text-center py-4 text-xs text-gray-500 mt-6">
        <p>جميع الحقوق محفوظة &copy; 2026 <span class="text-gold-400 font-bold">عالم الكاسر للعبارات</span></p>
    </footer>

    <!-- Messages Modal (نافذة عرض المسجات) -->
    <div id="messagesModal" class="fixed inset-0 bg-black/80 backdrop-blur-sm z-50 hidden flex items-center justify-center p-3 sm:p-4">
        <div class="bg-gray-900 border-2 border-gold-500 rounded-3xl w-full max-w-xl max-h-[85vh] flex flex-col shadow-2xl overflow-hidden animate-fade-in">
            <!-- Modal Header -->
            <div class="bg-gradient-to-r from-gold-700 via-gold-600 to-gold-800 px-4 py-3 text-black font-bold flex justify-between items-center shadow-md">
                <div class="flex items-center gap-2">
                    <span id="modalIcon" class="text-lg"></span>
                    <h2 id="modalCategoryTitle" class="text-lg font-black">عنوان القسم</h2>
                </div>
                <div class="flex items-center gap-2">
                    <span id="modalMsgBadge" class="bg-black text-gold-300 text-xs px-2.5 py-1 rounded-full font-bold">0</span>
                    <button onclick="closeModal()" class="w-8 h-8 bg-black/20 hover:bg-black/40 text-black rounded-full flex items-center justify-center transition">
                        <i class="fa-solid fa-xmark text-lg"></i>
                    </button>
                </div>
            </div>

            <!-- Controls in Modal -->
            <div class="p-3 bg-gray-950 border-b border-gray-800 flex justify-between items-center gap-2 text-xs">
                <span class="text-gray-400">تصفح وتوليد الرسائل:</span>
                <button onclick="generateMoreMessages()" class="bg-gold-500/20 hover:bg-gold-500/30 text-gold-300 border border-gold-500/50 px-3 py-1.5 rounded-xl flex items-center gap-1.5 transition">
                    <i class="fa-solid fa-arrows-rotate text-xs"></i>
                    <span>توليد عبارات جديدة</span>
                </button>
            </div>

            <!-- Messages List Body -->
            <div id="messagesContainer" class="p-4 overflow-y-auto flex-grow space-y-3.5 bg-gray-900/50">
                <!-- سيتم عرض العبارات هنا -->
            </div>
        </div>
    </div>

    <!-- Modal إضافة عبارة جديدة -->
    <div id="addModal" class="fixed inset-0 bg-black/80 backdrop-blur-sm z-50 hidden flex items-center justify-center p-4">
        <div class="bg-gray-900 border-2 border-gold-500 rounded-3xl w-full max-w-md p-5 shadow-2xl space-y-4">
            <div class="flex justify-between items-center border-b border-gray-800 pb-3">
                <h3 class="text-lg font-bold text-gold-400 flex items-center gap-2">
                    <i class="fa-solid fa-pen-to-square"></i> إضافة عبارة جديدة
                </h3>
                <button onclick="closeAddModal()" class="text-gray-400 hover:text-white">
                    <i class="fa-solid fa-xmark text-xl"></i>
                </button>
            </div>

            <div>
                <label class="block text-xs text-gray-300 mb-1">اختر القسم:</label>
                <select id="newMsgCategory" class="w-full bg-gray-800 border border-gold-500/40 text-white rounded-xl p-2.5 text-sm focus:outline-none focus:border-gold-400">
                    <!-- سيتم ملئه بالتصنيفات -->
                </select>
            </div>

            <div>
                <label class="block text-xs text-gray-300 mb-1">نص العبارة أو المسج:</label>
                <textarea id="newMsgText" rows="4" placeholder="اكتب العبارة هنا..." 
                    class="w-full bg-gray-800 border border-gold-500/40 text-white rounded-xl p-2.5 text-sm focus:outline-none focus:border-gold-400 resize-none"></textarea>
            </div>

            <div class="flex justify-end gap-2 pt-2">
                <button onclick="closeAddModal()" class="px-4 py-2 bg-gray-800 text-gray-300 text-xs font-bold rounded-xl hover:bg-gray-700">إلغاء</button>
                <button onclick="saveCustomMessage()" class="px-5 py-2 bg-gradient-to-r from-gold-500 to-gold-600 text-black text-xs font-bold rounded-xl hover:from-gold-400 hover:to-gold-500">حفظ العبارة</button>
            </div>
        </div>
    </div>

    <!-- Toast Alert Notification -->
    <div id="toast" class="fixed bottom-5 left-1/2 -translate-x-1/2 bg-gold-500 text-black px-4 py-2.5 rounded-2xl shadow-xl font-bold text-xs flex items-center gap-2 opacity-0 pointer-events-none transition-all duration-300 z-50 border border-white">
        <i class="fa-solid fa-circle-check text-base"></i>
        <span id="toastMsg">تم النسخ بنجاح!</span>
    </div>

    <script>
        // كافة الأقسام الـ 54 بالكامل مع أعدادها الأيقونات والتصميم المطابق للصور
        const categoriesData = [
            { id: 1, title: "حكم أمثال", count: 26558, icon: "🦉", bgIcon: "fa-book" },
            { id: 2, title: "حب غرام", count: 13294, icon: "💖", bgIcon: "fa-heart" },
            { id: 3, title: "حالات منوعة", count: 5798, icon: "🌐", bgIcon: "fa-share-nodes" },
            { id: 4, title: "WhatsApp", count: 5762, icon: "💬", bgIcon: "fa-whatsapp" },
            { id: 5, title: "نكات", count: 4648, icon: "😄", bgIcon: "fa-face-laugh-squint" },
            { id: 6, title: "خواطر", count: 4430, icon: "📜", bgIcon: "fa-scroll" },
            { id: 7, title: "إسلاميات", count: 3458, icon: "🌙", bgIcon: "fa-mosque" },
            { id: 8, title: "مخرفات", count: 3909, icon: "✨", bgIcon: "fa-wand-magic-sparkles" },
            { id: 9, title: "Facebook", count: 3487, icon: "📘", bgIcon: "fa-facebook" },
            { id: 10, title: "ألم حزن", count: 2824, icon: "🩹", bgIcon: "fa-face-sad-tear" },
            { id: 11, title: "شوق حنين", count: 2692, icon: "🧸", bgIcon: "fa-box-archive" },
            { id: 12, title: "عتاب", count: 1556, icon: "💔", bgIcon: "fa-heart-crack" },
            { id: 13, title: "وداع فراق", count: 969, icon: "🍂", bgIcon: "fa-door-open" },
            { id: 14, title: "كلام للعظماء", count: 799, icon: "👑", bgIcon: "fa-crown" },
            { id: 15, title: "كبرياء", count: 837, icon: "🦁", bgIcon: "fa-user-shield" },
            { id: 16, title: "هل تعلم", count: 738, icon: "❓", bgIcon: "fa-circle-question" },
            { id: 17, title: "درر", count: 1931, icon: "💎", bgIcon: "fa-gem" },
            { id: 18, title: "مسافر", count: 59, icon: "🧳", bgIcon: "fa-plane" },
            { id: 19, title: "رمضان", count: 685, icon: "🌙", bgIcon: "fa-moon" },
            { id: 20, title: "تهاني للعام", count: 514, icon: "🎉", bgIcon: "fa-glass-cheers" },
            { id: 21, title: "تهاني زواج", count: 443, icon: "💍", bgIcon: "fa-ring" },
            { id: 22, title: "إلى أمي", count: 410, icon: "👩‍👧", bgIcon: "fa-hands-holding-child" },
            { id: 23, title: "اعتذارات", count: 478, icon: "🙇‍♂️", bgIcon: "fa-hands-clasping" },
            { id: 24, title: "صداقة", count: 497, icon: "🤝", bgIcon: "fa-user-group" },
            { id: 25, title: "بعثات للأمل", count: 400, icon: "🌟", bgIcon: "fa-sun" },
            { id: 26, title: "عيد الحب", count: 505, icon: "❤️", bgIcon: "fa-gift" },
            { id: 27, title: "غرور أنثى", count: 348, icon: "👸", bgIcon: "fa-venus" },
            { id: 28, title: "تهاني عيد الفطر", count: 675, icon: "🎈", bgIcon: "fa-cake-candles" },
            { id: 29, title: "ذكرى الزواج", count: 671, icon: "🥂", bgIcon: "fa-champagne-glasses" },
            { id: 30, title: "مقالب", count: 740, icon: "😜", bgIcon: "fa-face-grin-tears" },
            { id: 31, title: "الجمعة", count: 823, icon: "🕋", bgIcon: "fa-kaaba" },
            { id: 32, title: "رومانسي", count: 1172, icon: "💌", bgIcon: "fa-envelope-open-text" },
            { id: 33, title: "مدح", count: 889, icon: "🏅", bgIcon: "fa-award" },
            { id: 34, title: "مسائية", count: 514, icon: "🌃", bgIcon: "fa-cloud-moon" },
            { id: 35, title: "صباحية", count: 1445, icon: "🌅", bgIcon: "fa-sun" },
            { id: 36, title: "غزل", count: 589, icon: "🌹", bgIcon: "fa-rose" },
            { id: 37, title: "معلومات مفيدة", count: 588, icon: "💡", bgIcon: "fa-lightbulb" },
            { id: 38, title: "كلمات راقية", count: 254, icon: "⚜️", bgIcon: "fa-feather-pointed" },
            { id: 39, title: "تهاني للخطوبة", count: 263, icon: "💍", bgIcon: "fa-handshake" },
            { id: 40, title: "تهاني بالمولود", count: 116, icon: "👶", bgIcon: "fa-baby" },
            { id: 41, title: "تهاني منوعة", count: 65, icon: "🎊", bgIcon: "fa-bullhorn" },
            { id: 42, title: "خيانة غدر", count: 110, icon: "🗡️", bgIcon: "fa-user-slash" },
            { id: 43, title: "تحقيق الأمنيات", count: 115, icon: "🌠", bgIcon: "fa-star" },
            { id: 44, title: "تهاني عيد الميلاد", count: 206, icon: "🎂", bgIcon: "fa-cake-candles" },
            { id: 45, title: "عائليات", count: 102, icon: "🏡", bgIcon: "fa-house-chimney-window" },
            { id: 46, title: "اسماء الله الحسنى", count: 95, icon: "✨", bgIcon: "fa-star-and-crescent" },
            { id: 47, title: "شعر أصيل", count: 53, icon: "✒️", bgIcon: "fa-pen-fancy" },
            { id: 48, title: "تهاني عيد الأضحى", count: 72, icon: "🐑", bgIcon: "fa-square-poll-vertical" },
            { id: 49, title: "دعاء مستجاب", count: 55, icon: "🤲", bgIcon: "fa-hands-praying" },
            { id: 50, title: "عبر مؤلمة", count: 74, icon: "😢", bgIcon: "fa-face-sad-cry" },
            { id: 51, title: "تهاني النجاح والتفوق", count: 54, icon: "🎓", bgIcon: "fa-graduation-cap" },
            { id: 52, title: "عزاء", count: 209, icon: "🖤", bgIcon: "fa-ribbon" },
            { id: 53, title: "إعلان وفاة", count: 13, icon: "🎗️", bgIcon: "fa-skull" },
            { id: 54, title: "رد على المعزين", count: 39, icon: "🕊️", bgIcon: "fa-dove" }
        ];

        // قاعدة بيانات العبارات الثابتة والقابلة للتوليد الموسع
        const basePhrases = {
            "حكم أمثال": [
                "من طال حلمه كثرت عداوته، ومن قلّ كلامه كثرت سلامته.",
                "خير الكلام ما قل ودل، ولم يطل فيمل.",
                "إذا تم العقل نقص الكلام، وخير الأمور أوساطها.",
                "لا تؤجل عمل اليوم إلى الغد، فلكل يوم عمله ورزقه.",
                "العلم في الصغر كالنقش على الحجر.",
                "لسان العاقل وراء قلبه، وقلب الأحمق وراء لسانه."
            ],
            "حب غرام": [
                "أنت النبض الذي يعيش في صدري، وكل دقة تناديك بصوت دافئ.",
                "عيناك هما وطني، وابتسامتك هي الأمن والأمان الذي أبحث عنه.",
                "لو كان لي أن أختار أمنية واحدة لكانت أن أقضي كل حياتي بقربك.",
                "في حبك وجدت ذاتي، وفي قربك نسيت كل أوجاعي.",
                "أنت ليست شيئاً في حياتي، بل أنت كل حياتي."
            ],
            "حالات منوعة": [
                "كن قويًا فالقادم أجمل بإذن الله، ولا تحزن على ما مضى.",
                "الأيام اللطيفة تأتي لمن يبتسم لها ويرتجي الخيرة من ربه.",
                "الحياة أسرار، وأجمل أسرارها قلوب صادقة تدعو لك بالخير.",
                "استمتع بتفاصيل يومك الصغيرة، فهي صنع الحياة الحقيقية."
            ],
            "WhatsApp": [
                "يسعد صباحكم بكل خير وسعادة، ويوم جميل يملأه التوفيق.",
                "اللهم في هذا اليوم اكتب لنا التوفيق واليسر في كل خطوة.",
                "جمعة مباركة معطرة بذكر الله والصلاة على النبي الكريم."
            ],
            "نكات": [
                "واحد محشش سألوه: ايش رأيك في الزواج المبكر؟ قال: يعني الساعة كم؟",
                "مرة واحد دخل مقهى طلب قهوة سريعة، جابوا له القهوة وهي تجري!",
                "محشش مسكوه الشرطة قالوا له: أنت سكران؟ قال: لا والله بس شارب ببسي منتهي التاريخ!"
            ],
            "خواطر": [
                "يبقى الوجود الجميل محفوراً في الذاكرة رغم غياب أصحابه.",
                "سلاماً على قلوب تحمل من الأمل ما لا يراه الآخرون في عتمة الحياة.",
                "الهدوء ليس ضعفاً، بل هو الفن الأصيل في التعامل مع الضجيج."
            ],
            "إسلاميات": [
                "ألا بذكر الله تطمئن القلوب، وتنقشع الهموم والكروب.",
                "سبحان الله وبحمده، سبحان الله العظيم عداد خلقه ورضا نفسه.",
                "اللهم اجعلنا ممن يقال لهم ادخلوها بسلام آمنين."
            ]
        };

        // توليد جمل وعبارات إضافية تلقائياً لأي قسم
        function generateCategoryPhrases(title, categoryId) {
            let list = basePhrases[title] ? [...basePhrases[title]] : [];
            
            // قراءة الرسائل المضافة من المالك
            const customMsgs = JSON.parse(localStorage.getItem('custom_msgs_' + categoryId) || '[]');
            list = [...customMsgs, ...list];

            // توليد عبارات تلقائية للوصول لثراء المحتوى
            const prefixes = [
                "من أجمل ما قيل في ", "كلمات ذهبية عن ", "همسة دافئة في ", 
                "عبارة راقية تختصر ", "أروع ما كتب عن ", "نفحات فاخرة تناسب "
            ];
            const phrasesPool = [
                "الوفاء والصدق هما العنوان الحقيقي لكل العلاقات الناجحة.",
                "مهما طال الطريق، فإن شمس الأمل ستشرق لتضيء كل ظلمة.",
                "في زوايا الحياة قصص لا يفهمها إلا من عاش تفاصيلها بقلبه.",
                "القوة الحقيقية هي أن تبتسم وفي عينيك الف معنى وحكاية.",
                "يبقى الأثر الطيب هو الشيء الوحيد الذي لا يغيره الزمان.",
                "كن لنفسك كل شيء ولا تنتظر التقدير إلا من خالقك.",
                "أجمل الأوقات هي التي تقضيها برفقة من تحب في هدوء ورضا.",
                "الصفاء الداخلي هو مفتاح السعادة والراحة النفسية الدائمة."
            ];

            // إكمال القائمة لتبدو كقاعدة بيانات ضخمة
            for (let i = 1; i <= 20; i++) {
                const prefix = prefixes[i % prefixes.length];
                const poolItem = phrasesPool[(i + categoryId) % phrasesPool.length];
                list.push(`${prefix} ${title}: ${poolItem} (${i + 10})`);
            }
            return list;
        }

        let currentActiveCat = null;
        let activeCategoryMessages = [];

        // عرض الأقسام في الصفحة الرئيسية
        function renderCategories(data) {
            const container = document.getElementById('categoriesGrid');
            container.innerHTML = '';

            data.forEach(cat => {
                const cardHTML = `
                    <div onclick="openModal(${cat.id})" class="gold-card rounded-2xl p-2.5 sm:p-3 text-center cursor-pointer relative flex flex-col justify-between items-center min-h-[105px] sm:min-h-[115px] select-none">
                        <!-- جرس التنبيه مع العدد فوقه -->
                        <div class="absolute top-1.5 left-1.5 flex items-center bg-black/85 text-gold-300 rounded-full px-2 py-0.5 border border-gold-500/40 shadow-sm">
                            <i class="fa-solid fa-bell text-[9px] ml-1 text-gold-400"></i>
                            <span class="text-[10px] font-extrabold">${cat.count.toLocaleString('ar-EG')}</span>
                        </div>

                        <!-- أيقونة القسم الرسمية -->
                        <div class="mt-4 mb-1 flex items-center justify-center w-10 h-10 rounded-full bg-black/20 backdrop-blur-sm border border-gold-300/40 text-xl shadow-inner">
                            <span>${cat.icon}</span>
                        </div>

                        <!-- اسم القسم -->
                        <h3 class="text-black font-black text-xs sm:text-sm tracking-tight leading-tight line-clamp-1">${cat.title}</h3>
                    </div>
                `;
                container.innerHTML += cardHTML;
            });

            document.getElementById('totalCatCount').innerText = data.length;
            document.getElementById('noResults').classList.toggle('hidden', data.length > 0);
        }

        // التصفية والبحث الفوري
        function filterCategories() {
            const query = document.getElementById('searchInput').value.trim().toLowerCase();
            const clearBtn = document.getElementById('clearSearch');
            
            if (query.length > 0) {
                clearBtn.classList.remove('hidden');
                const filtered = categoriesData.filter(c => c.title.toLowerCase().includes(query));
                renderCategories(filtered);
            } else {
                clearBtn.classList.add('hidden');
                renderCategories(categoriesData);
            }
        }

        function resetSearch() {
            document.getElementById('searchInput').value = '';
            filterCategories();
        }

        // فتح نافذة عرض العبارات Modal
        function openModal(catId) {
            const cat = categoriesData.find(c => c.id === catId);
            if (!cat) return;

            currentActiveCat = cat;
            document.getElementById('modalCategoryTitle').innerText = cat.title;
            document.getElementById('modalIcon').innerText = cat.icon;
            document.getElementById('modalMsgBadge').innerText = cat.count.toLocaleString('ar-EG');

            activeCategoryMessages = generateCategoryPhrases(cat.title, cat.id);
            renderModalMessages();

            document.getElementById('messagesModal').classList.remove('hidden');
            document.body.style.overflow = 'hidden';
        }

        // عرض قائمة المسجات داخل Modal
        function renderModalMessages() {
            const container = document.getElementById('messagesContainer');
            container.innerHTML = '';

            activeCategoryMessages.forEach((msg, idx) => {
                const msgCard = `
                    <div class="bg-gray-800/90 border border-gold-500/30 rounded-2xl p-3.5 relative shadow-md hover:border-gold-400/60 transition group">
                        <div class="flex items-start justify-between gap-3 mb-2">
                            <span class="bg-gold-500/20 text-gold-300 text-[10px] font-bold px-2 py-0.5 rounded-md border border-gold-500/30">#${idx + 1}</span>
                            <div class="flex items-center gap-1.5">
                                <button onclick="copyMsg('${escapeQuotes(msg)}')" title="نسخ النص" class="w-8 h-8 rounded-xl bg-gray-700/80 hover:bg-gold-500 hover:text-black text-gold-400 flex items-center justify-center transition">
                                    <i class="fa-solid fa-copy text-xs"></i>
                                </button>
                                <button onclick="shareWhatsApp('${escapeQuotes(msg)}')" title="مشاركة عبر واتساب" class="w-8 h-8 rounded-xl bg-emerald-600/30 hover:bg-emerald-500 hover:text-black text-emerald-400 flex items-center justify-center transition">
                                    <i class="fa-brands fa-whatsapp text-sm"></i>
                                </button>
                            </div>
                        </div>
                        <p class="text-gray-100 text-sm sm:text-base leading-relaxed font-semibold selection:bg-gold-500 selection:text-black">${msg}</p>
                    </div>
                `;
                container.innerHTML += msgCard;
            });
        }

        // توليد المزيد من العبارات ديناميكياً
        function generateMoreMessages() {
            if (!currentActiveCat) return;
            const cat = currentActiveCat;
            const extraPhrases = [
                `كل بيت يمتلئ بالدفء حين تتواجد فيه النوايا الطيبة في ${cat.title}.`,
                `من كنوز ${cat.title}: الصبر مفتاح الفرج والكلمة الطيبة صدقة.`,
                `في هذا الوقت بالذات، تذكر أنك أقوى مما تظن في ${cat.title}.`,
                `لا تجعل يومك يمر دون أن تترك أثراً يبتسم له غيرك في ${cat.title}.`
            ];
            
            activeCategoryMessages = [...extraPhrases, ...activeCategoryMessages];
            renderModalMessages();
            showToast("تم توليد عبارات جديدة للقسم!");
        }

        function closeModal() {
            document.getElementById('messagesModal').classList.add('hidden');
            document.body.style.overflow = 'auto';
        }

        // نسخ النص للصبورة
        function copyMsg(text) {
            if (navigator.clipboard && navigator.clipboard.writeText) {
                navigator.clipboard.writeText(text);
            } else {
                const textarea = document.createElement('textarea');
                textarea.value = text;
                document.body.appendChild(textarea);
                textarea.select();
                document.execCommand('copy');
                document.body.removeChild(textarea);
            }
            showToast("تم نسخ العبارة بنجاح!");
        }

        // مشاركة الواتساب
        function shareWhatsApp(text) {
            const url = `https://api.whatsapp.com/send?text=${encodeURIComponent(text + '\n\n— من تطبيق عالم الكاسر للعبارات')}`;
            window.open(url, '_blank');
        }

        // تنبيه Toast
        function showToast(message) {
            const toast = document.getElementById('toast');
            document.getElementById('toastMsg').innerText = message;
            toast.classList.remove('opacity-0', 'pointer-events-none');
            toast.classList.add('opacity-100');
            setTimeout(() => {
                toast.classList.remove('opacity-100');
                toast.classList.add('opacity-0', 'pointer-events-none');
            }, 2500);
        }

        function escapeQuotes(str) {
            return str.replace(/'/g, "\\'").replace(/"/g, '&quot;');
        }

        // Modal إضافة عبارة مخصصة
        function openAddModal() {
            const select = document.getElementById('newMsgCategory');
            select.innerHTML = '';
            categoriesData.forEach(c => {
                select.innerHTML += `<option value="${c.id}">${c.icon} ${c.title}</option>`;
            });
            document.getElementById('addModal').classList.remove('hidden');
        }

        function closeAddModal() {
            document.getElementById('addModal').classList.add('hidden');
            document.getElementById('newMsgText').value = '';
        }

        function saveCustomMessage() {
            const catId = document.getElementById('newMsgCategory').value;
            const text = document.getElementById('newMsgText').value.trim();

            if (!text) {
                showToast("يرجى كتابة نص العبارة أولاً!");
                return;
            }

            const customMsgs = JSON.parse(localStorage.getItem('custom_msgs_' + catId) || '[]');
            customMsgs.unshift(text);
            localStorage.setItem('custom_msgs_' + catId, JSON.stringify(customMsgs));

            closeAddModal();
            showToast("تمت إضافة العبارة وحفظها بنجاح!");
            
            // تحديث القسم إذا كان مفتوحاً
            if (currentActiveCat && currentActiveCat.id == catId) {
                openModal(currentActiveCat.id);
            }
        }

        // التشغيل الابتدائي
        window.onload = function() {
            renderCategories(categoriesData);
        };
    </script>
</body>
</html>