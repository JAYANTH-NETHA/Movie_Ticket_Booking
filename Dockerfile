FROM tomcat:11-jdk25-temurin

COPY Movie_Ticket_Booking.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
