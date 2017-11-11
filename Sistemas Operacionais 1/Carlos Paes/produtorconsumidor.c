
#include <stdio.h>
#include <stdlib.h> 
#include <string.h>

#define BUFFER_SIZE  500


struct buffercircular {
    char *buffer;
    int produ;
    int cons;
    int size;
    int contador;
};


int main(char *rbuffer, struct buffercircular *rb, size_t size) {
    rb->buffer = rbuffer;
    rb->size = size;
        rb->cons = 0;
        rb->produ = 0; 
        rb->contador = 0;
    return 0;
}

int produtor (struct buffercircular *rb, unsigned char * buf, int len)
{
    int i;
    if(len > rb->size -  rb->contador) {
       return -1;
    }

    i = rb->produ;
    if(i == rb->size) {
       i = 0;
    }    
    else if (i + len > rb->size) {
        memcpy(rb->buffer + i, buf, rb->size - i);
        buf += rb->size - i;
        len = len - (rb->size - i);
        rb->contador += len;
        i = 0;
    }
    memcpy(rb->buffer + i, buf, len);
    rb->produ = i + len;
    rb->contador += len;
    return 0;
}

int consumidor (struct buffercircular *rb, unsigned char * buf, int max)
{
    int i;
    if(max > rb->contador) {
      return  -1; 
    }  

    i = rb->cons;
    if (i == rb->size) {
       i = 0;
    } else if (i + max > rb->size) {
        memcpy(buf, rb->buffer + i, rb->size - i);
        buf += rb->size - i;
        max = max - (rb->size - i);
        rb->contador -= max;
        i = 0;
    }
    memcpy(buf, rb->buffer + i, max);
    rb->cons = i + max;
    rb->contador -= max;

    return 0;
}