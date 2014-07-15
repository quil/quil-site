#!/bin/bash
for html in *html
do
    echo "Processing $html"
    tidy -im $html
done
