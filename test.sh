#!/bin/bash

# Book 1
title1="Echoes of Eternity"
author1="Jasmine Evergreen"
isbn1="1234567890123"

# Book 2
title2="Whispers in the Void"
author2="Alex Starfield"
isbn2="0987654321098"

# Book 3
title3="Catalyst of Shadows"
author3="Eleanor Mysteryson"
isbn3="9876543210123"

# Book 4
title4="Harmony's Lament"
author4="William Historicalton"
isbn4="4567890123456"

# Book 5
title5="Infinite Horizon"
author5="Dystopia Writerson"
isbn5="3456789012345"

# Book 6
title6="The Alchemy of Time"
author6="Victoria Fantasyberg"
isbn6="2345678901234"

# Book 7
title7="Threads of Destiny"
author7="Drama Contemporarino"
isbn7="5432109876543"

# Book 8
title8="Quantum Quandary"
author8="Sci-Fi Thrillington"
isbn8="6789012345678"

# Book 9
title9="Serpent's Embrace"
author9="Rosalind Romancington"
isbn9="7890123456789"

# Book 10
title10="The Art of Forgetting"
author10="Theodore Thrillerstein"
isbn10="8901234567890"

# Set the URL for the POST request
url="http://localhost:8080/books/add"

# Function to send POST request
send_post_request() {
  local title=$1
  local author=$2
  local isbn=$3

  # Send the POST request using curl
  curl $url -d title=$title -d author=$author -d isbn=$isbn
}

# Send POST requests for each book


send_post_request "$title1" "$author1" "$isbn1"
send_post_request "$title2" "$author2" "$isbn2"
send_post_request "$title3" "$author3" "$isbn3"
send_post_request "$title4" "$author4" "$isbn4"
send_post_request "$title5" "$author5" "$isbn5"
send_post_request "$title6" "$author6" "$isbn6"
send_post_request "$title7" "$author7" "$isbn7"
send_post_request "$title8" "$author8" "$isbn8"
send_post_request "$title9" "$author9" "$isbn9"
send_post_request "$title10" "$author10" "$isbn10"

