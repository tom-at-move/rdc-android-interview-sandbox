package com.move.rdc_android_interview_sandbox.util


val cities: List<String> = listOf(
    "Seattle",
    "Napa",
    "San Jose",
    "San Francisco",
    "New York",
    "Yosemite",
    "Atlanta",
    "Vancouver",
    "Richmond",
    "Boston",
    "Austin",
    "Aurora",
    "Alexandria"
)

val states: List<String> = listOf(
    "California",
    "Texas",
    "New York",
    "Washington",
    "Georgia",
    "Maryland",
    "Michigan",
    "Massachusetts",
    "Marshall Islands"
)

val lines: List<String> = listOf(
    "1234 Fake Street",
    "221B Baker Street",
    "99, rue de Rivoli",
    "20121 Piazza della Scala",
    "10 Downing Street",
    "1060 West Addison Street"
)

val imageLinks: List<String> = listOf(
    "https://ap.rdcpix.com/3095123326/e991bb937b1be22c1d45c124e5fd73bel-m0x.jpg",
    "https://ap.rdcpix.com/3974025438/5a733b76708683d73637a59bc8533d0bl-m36x.jpg",
    "https://ap.rdcpix.com/3243177365/de0b5f78cb6974710c4a798fde32e3a1l-m20x.jpg",
    "https://ap.rdcpix.com/2227949709/b8b236307b00af9cdb4bb539a0a6f3fel-m29x.jpg",
    "https://ap.rdcpix.com/2630090179/642cd78c95f46c59a5df570e21c927dcl-m1x.jpg",
    "https://ap.rdcpix.com/2833300492/87a2d0387465b0a9e6e01712476f8ffel-m26x.jpg",
    "https://ap.rdcpix.com/3061215485/8ca5cadee28c0ede7cf5f78299a9e389l-m8x.jpg",
    "https://ap.rdcpix.com/2290984454/d9bb38583fa0426c8179ec29d92552f5l-m10x.jpg",
    "https://ap.rdcpix.com/1912578868/640719faefdad67ec1b0a2608d8ca624l-m11x.jpg",
    "https://ap.rdcpix.com/1134949108/7c588c8945227e78b5d6fdc24585f55dl-m1x.jpg"
)

fun getTestList(): ArrayList<com.move.rdc_android_interview_sandbox.data.models.Property> {
    val arr: ArrayList<com.move.rdc_android_interview_sandbox.data.models.Property> = ArrayList(5)

    repeat((0..5).count()) {
        arr += getProperty()
    }

    return arr
}

private fun getProperty(): com.move.rdc_android_interview_sandbox.data.models.Property {
    val property = com.move.rdc_android_interview_sandbox.data.models.Property(
        getAddress(),
        (800000..10000000).random(),
        getPhotos()
    )
    return property
}

private fun getPhotos(): List<com.move.rdc_android_interview_sandbox.data.models.Photo>? {
    val photo =
        com.move.rdc_android_interview_sandbox.data.models.Photo("https://ap.rdcpix.com/3095123326/e991bb937b1be22c1d45c124e5fd73bel-m0x.jpg")
    return listOf(photo)
}

private fun getAddress(): com.move.rdc_android_interview_sandbox.data.models.Address {
    val address = com.move.rdc_android_interview_sandbox.data.models.Address(
        line = lines.random(),
        city = cities.random(),
        state = states.random(),
        postalCode = "",
        stateCode = ""
    )
    return address
}

fun presentableAddress(address: com.move.rdc_android_interview_sandbox.data.models.Address?): String {
    return if (address != null) {
        listOfNotNull(address.line, address.city, address.state).joinToString()
    } else {
        "Error! No address found."
    }
}


fun presentablePrice(price: Int?): String {
    return if (price != null) {
        CurrencyHelper.instance.currencyInstance.format(price)
    } else {
        "Price Error"
    }
}

fun singlePhoto(photos: List<com.move.rdc_android_interview_sandbox.data.models.Photo>?): String {
    return if (!photos.isNullOrEmpty()) {
        photos.firstOrNull()?.href ?: ""
    } else {
        ""
    }
}