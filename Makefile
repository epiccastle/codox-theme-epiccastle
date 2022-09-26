clean:
	clj -T:build clean

jar:
	clj -T:build jar

upload:
	clj -T:build upload
