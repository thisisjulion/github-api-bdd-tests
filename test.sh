if [ -z ${1+x} ]; then echo "Missing username argument"; fi
if [ -z ${2+x} ]; then echo "Missing token argument"; fi
if [ -z ${1+x} ] | [ -z ${2+x} ]; then exit; fi

export AUTH_BASIC_USERNAME=$1
export AUTH_BASIC_TOKEN=$2

echo "Set auth variables into environment"
echo "Starting execution of the tests..."

mvn clean verify