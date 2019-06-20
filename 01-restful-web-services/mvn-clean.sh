for dir in */ ; do
    echo -e "\n${dir}"
    cd ${dir} 
    mvn clean
    cd - > /dev/null
done
