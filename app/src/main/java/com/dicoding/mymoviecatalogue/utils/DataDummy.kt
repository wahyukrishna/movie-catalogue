package com.dicoding.mymoviecatalogue.utils

import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.MovieEntity

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "A Star Is Born",
                4,
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2018",
                "Bradley Cooper",
                "https://www.themoviedb.org/movie/332562-a-star-is-born/cast#media_v4",
                "nSbzyEJ8X9E",
                R.drawable.poster_a_start_is_born
            )
        )

        movies.add(
            MovieEntity(
                "m2",
                "Alita:Battle Angel",
                4,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019",
                "Robert Rodriguez",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel/cast#media_v4",
                "puKWa8hrvA8",
                R.drawable.poster_alita
            )
        )

        movies.add(
            MovieEntity(
                "m3",
                "Aquaman",
                4,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018",
                "James Wan",
                "https://www.themoviedb.org/movie/297802-aquaman/cast#media_v4",
                "2wcj6SrX4zw",
                R.drawable.poster_aquaman
            )
        )

        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                5,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                "Bryan Singer",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody/cast#media_v4",
                "mP0VHJYFOAU",
                R.drawable.poster_bohemian
            )
        )

        movies.add(
            MovieEntity(
                "m5",
                "Creed II",
                4,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018",
                "Steven Caple Jr.",
                "https://www.themoviedb.org/movie/480530-creed-ii/cast#media_v4",
                "cPNVNqn4T9I",
                R.drawable.poster_creed
            )
        )

        movies.add(
            MovieEntity(
                "m6",
                "Glass",
                4,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019",
                "M. Night Shyamalan",
                "https://www.themoviedb.org/movie/450465-glass/cast#media_v4",
                "Q7ztHi9ejp4",
                R.drawable.poster_glass
            )
        )

        movies.add(
            MovieEntity(
                "m7",
                "Avengers:Infinity War",
                5,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018",
                "Anthony Russo, Joe Russo",
                "https://www.themoviedb.org/movie/299536-avengers-infinity-war/cast#media_v4",
                "6ZfuNTqbHE8",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MovieEntity(
                "m8",
                "Mortal Engines",
                4,
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2018",
                "Christian Rivers",
                "https://www.themoviedb.org/movie/428078-mortal-engines/cast#media_v4",
                "IRsFc2gguEg",
                R.drawable.poster_mortal_engines
            )
        )

        movies.add(
            MovieEntity(
                "m9",
                "Overlord",
                4,
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "2018",
                "Julius Avery",
                "https://www.themoviedb.org/movie/438799-overlord/cast#media_v4",
                "USPd0vX2sdc",
                R.drawable.poster_overlord
            )
        )

        movies.add(
            MovieEntity(
                "m10",
                "Robin Hood",
                3,
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "2018",
                "Otto Bathurst",
                "https://www.themoviedb.org/movie/375588-robin-hood/cast#media_v4",
                "tJfDBSWYqU8",
                R.drawable.poster_robin_hood
            )
        )

        movies.add(
            MovieEntity(
                "m11",
                "Serenity",
                3,
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "2019",
                "Steven Knight",
                "https://www.themoviedb.org/movie/452832-serenity/cast#media_v4",
                "k3zMlsEK8xA",
                R.drawable.poster_serenity
            )
        )

        return movies
    }

    fun generateDummyTV(): List<MovieEntity> {
        val tvShow = ArrayList<MovieEntity>()

        tvShow.add(
            MovieEntity(
                "t1",
                "Arrow",
                4,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-2020",
                "Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
                "https://www.themoviedb.org/tv/1412-arrow/cast#media_v4",
                "hTv13EjlLNg",
                R.drawable.tv_poster_arrow
            )
        )

        tvShow.add(
            MovieEntity(
                "t2",
                "Doom Patrol",
                4,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019-Present",
                "Jeremy Carver",
                "https://www.themoviedb.org/tv/79501-doom-patrol/cast#media_v4",
                "6tTM9nbRk5A",
                R.drawable.tv_poster_doom_patrol
            )
        )

        tvShow.add(
            MovieEntity(
                "t3",
                "Dragon Ball",
                5,
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986-1989",
                "Akira Toriyama",
                "https://www.themoviedb.org/tv/12609/cast#media_v4",
                "y_0APzy4BcU",
                R.drawable.tv_poster_dragon_ball
            )
        )

        tvShow.add(
            MovieEntity(
                "t4",
                "The Flash",
                4,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-Present",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                "https://www.themoviedb.org/tv/60735-the-flash/cast#media_v4",
                "Yj0l7iGKh8g",
                R.drawable.tv_poster_flash
            )
        )

        tvShow.add(
            MovieEntity(
                "t5",
                "Hanna",
                4,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019-Present",
                "David Farr",
                "https://www.themoviedb.org/tv/54155-hanna/cast#media_v4",
                "oNYp4i5N_s4",
                R.drawable.tv_poster_hanna
            )
        )

        tvShow.add(
            MovieEntity(
                "t6",
                "Iron Fist",
                4,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "2017-2018",
                "Scott Buck",
                "https://www.themoviedb.org/tv/62127-marvel-s-iron-fist/cast#media_v4",
                "f9OKL5no-S0",
                R.drawable.tv_poster_iron_fist
            )
        )

        tvShow.add(
            MovieEntity(
                "t7",
                "Naruto Shippuden",
                5,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007-2017",
                "Hayato Date",
                "https://www.themoviedb.org/tv/31910/cast#media_v4",
                "1WLO0Owi5-A",
                R.drawable.tv_poster_naruto_shipudden
            )
        )

        tvShow.add(
            MovieEntity(
                "t8",
                "Riverdale",
                5,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017-Present",
                "Roberto Aguirre-Sacasa",
                "https://www.themoviedb.org/tv/69050-riverdale/cast#media_v4",
                "HxtLlByaYTc",
                R.drawable.tv_poster_riverdale
            )
        )

        tvShow.add(
            MovieEntity(
                "t9",
                "Supergirl",
                4,
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015-Present",
                "Greg Berlanti, Ali Adler, Andrew Kreisberg",
                "https://www.themoviedb.org/tv/62688-supergirl/cast#media_v4",
                "Mh8MYFadTmQ",
                R.drawable.tv_poster_supergirl
            )
        )

        tvShow.add(
            MovieEntity(
                "t10",
                "The Simpsons",
                4,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989-Present",
                "Matt Groening",
                "https://www.themoviedb.org/tv/456-the-simpsons/cast#media_v4",
                "DX1iplQQJTo",
                R.drawable.tv_poster_the_simpson
            )
        )

        tvShow.add(
            MovieEntity(
                "t11",
                "The Walking Dead",
                5,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010-Present",
                "Frank Darabont",
                "https://www.themoviedb.org/tv/1402-the-walking-dead/cast#media_v4",
                "R1v0uFms68U",
                R.drawable.tv_poster_the_walking_dead
            )
        )

        return tvShow
    }

}