package com.sidharthr.oasisreader

data class ArticleMeta(
    val contentUrl: String,
    val imgUrl: String?,
    val title: String,
    val excerpt: String,
    val date: String,
    val publisher: String
)

data class Article (
    val meta: ArticleMeta,
    val originalContentHtml: String? = null,
    val readableContentHtml: String? = null
)

// TODO: Eventually Replace this with a list of articles from the database.
val sampleArticlesList = listOf<ArticleMeta>(
    ArticleMeta(
        contentUrl = "https://blog.sidharthr.com/how-computers-perceive-sound",
        imgUrl = null,
        title = "How Computers Perceive Sound",
        excerpt = "Way back in the 1700s, if you wanted to hear sound - the only way to do that was to go directly to the source. For music - find someone who played an instrument, or to sing a song for you. For hearing someone speak - go visit them in person. And if you couldn't do that? Too bad",
        date = "2023-05-14",
        publisher = "sidharthr.com"
    ),
    ArticleMeta(
        contentUrl = "https://stratechery.com/2023/china-chips-and-moores-law/",
        imgUrl = null,
        title = "China Chips and Moore’s Law",
        excerpt = "On Tuesday the Biden administration tightened export controls for advanced AI chips being sold to China; the primary target was Nvidia’s H800 and A800 chips, which were specifically designed to skirt controls put in place last year.",
        date = "2023-10-18",
        publisher = "stratechery.com"
    ),
    ArticleMeta(
        contentUrl = "https://stratechery.com/2023/china-chips-and-moores-law/",
        imgUrl = null,
        title = "China Chips and Moore’s Law",
        excerpt = "On Tuesday the Biden administration tightened export controls for advanced AI chips being sold to China; the primary target was Nvidia’s H800 and A800 chips, which were specifically designed to skirt controls put in place last year.",
        date = "2023-10-18",
        publisher = "stratechery.com"
    ),
    ArticleMeta(
        contentUrl = "https://stratechery.com/2023/china-chips-and-moores-law/",
        imgUrl = null,
        title = "China Chips and Moore’s Law",
        excerpt = "On Tuesday the Biden administration tightened export controls for advanced AI chips being sold to China; the primary target was Nvidia’s H800 and A800 chips, which were specifically designed to skirt controls put in place last year.",
        date = "2023-10-18",
        publisher = "stratechery.com"
    ),
    ArticleMeta(
        contentUrl = "https://stratechery.com/2023/china-chips-and-moores-law/",
        imgUrl = null,
        title = "China Chips and Moore’s Law",
        excerpt = "On Tuesday the Biden administration tightened export controls for advanced AI chips being sold to China; the primary target was Nvidia’s H800 and A800 chips, which were specifically designed to skirt controls put in place last year.",
        date = "2023-10-18",
        publisher = "stratechery.com"
    )
);

val sampleArticle = Article(
    meta = ArticleMeta(
        contentUrl = "https://blog.sidharthr.com/how-computers-perceive-sound",
        imgUrl = null,
        title = "How Computers Perceive Sound",
        excerpt = "Way back in the 1700s, if you wanted to hear sound - the only way to do that was to go directly to the source. For music - find someone who played an instrument, or to sing a song for you. For hearing someone speak - go visit them in person. And if you couldn't do that? Too bad",
        date = "2023-05-14",
        publisher = "sidharthr.com"
    ),
    originalContentHtml = """
        <html>
            <head>
                <title>How Computers Perceive Sound</title>
            </head>
            <body>
                <h1>How Computers Perceive Sound</h1>
                <p>Way back in the 1700s, if you wanted to hear sound - the only way to do that was to go directly to the source. For music - find someone who played an instrument, or to sing a song for you. For hearing someone speak - go visit them in person. And if you couldn't do that? Too bad</p>
            </body>
        </html>
    """.trimIndent(),
    readableContentHtml = """
        <html>
            <head>
                <title>How Computers Perceive Sound</title>
            </head>
            <body>
                <h1>How Computers Perceive Sound</h1>
                <p>Way back in the 1700s, if you wanted to hear sound - the only way to do that was to go directly to the source. For music - find someone who played an instrument, or to sing a song for you. For hearing someone speak - go visit them in person. And if you couldn't do that? Too bad</p>
            </body>
        </html>
    """.trimIndent()
)
